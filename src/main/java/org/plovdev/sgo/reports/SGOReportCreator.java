package org.plovdev.sgo.reports;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jspecify.annotations.NonNull;
import org.plovdev.sgo.SGOClient;
import org.plovdev.sgo.exceptions.ReportGenerationException;
import org.plovdev.sgo.reports.dto.*;
import org.plovdev.sgo.reports.listeners.ReportCreatingProgressListener;
import org.plovdev.sgo.reports.listeners.ReportTargetStatus;
import org.plovdev.sgo.reports.requests.CreateSGOReportQueue;
import org.plovdev.sgo.reports.requests.InitSignalRQueue;
import org.plovdev.sgo.reports.requests.LoadSGOReportRequest;
import org.plovdev.sgo.reports.requests.ws.SGONegotinateRequest;
import org.plovdev.sgo.reports.requests.ws.SGOSubmitReportTask;
import org.plovdev.sgo.utils.Globals;
import org.plovdev.sgo.ws.SGOWebSocketClient;
import org.plovdev.sgo.ws.WebSocketListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class SGOReportCreator {
    private static final Logger log = LoggerFactory.getLogger(SGOReportCreator.class);
    private final SGOClient client;
    private volatile ReportCreatingProgressListener progressListener = new ReportCreatingProgressListener() {
        @Override
        public void onProgress(ReportCreatingProgress progress) {
            log.debug("Report creating progress: {}", progress);
        }

        @Override
        public void onCreated(ReportCreated created) {
            log.debug("Report created: {}", created);
        }

        @Override
        public void onError(@NonNull ReportCreatingProgress error) {
            log.error("Report creating error: {}", error.getStatus());
        }
    };

    public SGOReportCreator(SGOClient client) {
        this.client = client;
    }

    public ReportCreatingProgressListener getProgressListener() {
        return progressListener;
    }

    public synchronized void setProgressListener(ReportCreatingProgressListener progressListener) {
        this.progressListener = Objects.requireNonNull(progressListener);
    }

    public SGOReport createReport(@NonNull SGOReportRequest reportRequest) {
        try {
            CompletableFuture<SGOReport> reportFuture = createReportAsync(reportRequest);
            return reportFuture.get(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new ReportGenerationException("Report generation failed: ", e);
        }
    }

    public List<CompletableFuture<SGOReport>> createReportsAsync(SGOReportRequest... reportRequests) {
        return Arrays.stream(reportRequests).map(this::createReportAsync).toList();
    }

    public CompletableFuture<SGOReport> createReportAsync(@NonNull SGOReportRequest reportRequest) {
        log.debug("Start creating report");
        CompletableFuture<SGOReport> reportFuture = new CompletableFuture<>();
        SGOWebSocketClient wsClient = client.createSGOWebSocketClient();
        wsClient.connect(new SGONegotinateRequest(), new WebSocketListenerAdapter() {
            @Override
            public void onMessage(String message) {
                if (message.equals("{}")) return;

                JsonObject reportStatus = Globals.GSON.fromJson(message, JsonObject.class);
                int type = reportStatus.get("type").getAsInt();
                if (type == 1) {
                    String target = reportStatus.get("target").getAsString();
                    JsonArray args = reportStatus.get("arguments").getAsJsonArray();
                    ReportTargetStatus status = ReportTargetStatus.valueOf(target);
                    if (status == ReportTargetStatus.progress) {
                        proccessProgressTarget(args);
                    } else if (status == ReportTargetStatus.complete) {
                        ReportCreated created = proccessCompleteTarget(args);
                        SGOReport report = client.loadReport(new LoadSGOReportRequest(created.getData()));
                        report.setReportType(reportRequest.getReportType());
                        report.setOutputType(reportRequest.getOutputType());
                        wsClient.close();
                        reportFuture.complete(report);
                    } else if (status == ReportTargetStatus.error) {
                        ReportCreatingProgress progress = proccessErrorTarget(args);
                        wsClient.close();
                        reportFuture.completeExceptionally(new ReportGenerationException(progress.getDetails()));
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                reportFuture.completeExceptionally(new ReportGenerationException(t));
                wsClient.close();
            }
        });

        try {
            wsClient.execute(new InitSignalRQueue());
            SGOReportQueue queue = client.execute(new CreateSGOReportQueue(reportRequest.getReportFilters(), reportRequest.getParams(), reportRequest.getReportType(), reportRequest.getOutputType()));
            log.debug("Report queue: {}", queue);
            wsClient.execute(new SGOSubmitReportTask(queue.getTaskId()));
        } catch (Exception e) {
            wsClient.close();
            reportFuture.completeExceptionally(e);
        }
        return reportFuture;
    }

    private void proccessProgressTarget(@NonNull JsonArray args) {
        JsonObject arg = args.get(0).getAsJsonObject();
        progressListener.onProgress(Globals.GSON.fromJson(arg, ReportCreatingProgress.class));
    }

    private ReportCreatingProgress proccessErrorTarget(@NonNull JsonArray args) {
        JsonObject arg = args.get(0).getAsJsonObject();
        ReportCreatingProgress progress = Globals.GSON.fromJson(arg, ReportCreatingProgress.class);
        progressListener.onError(progress);
        return progress;
    }

    private ReportCreated proccessCompleteTarget(@NonNull JsonArray args) {
        JsonObject arg = args.get(0).getAsJsonObject();
        ReportCreated created = Globals.GSON.fromJson(arg, ReportCreated.class);
        progressListener.onCreated(created);
        return created;
    }
}