package org.plovdev.sgo.reports.requests.ws;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.requests.SGORequest;
import org.plovdev.sgo.reports.SGOReportType;
import org.plovdev.sgo.utils.Globals;

import java.util.HashMap;
import java.util.Map;

public class SGOSubmitReportTask extends SGORequest<Void> {
    private int taskId;
    private SGOReportType reportType;
    private int invocationId = 0;
    private String target = "startTaskAsync";
    private int type = 1;

    public SGOSubmitReportTask(int taskId, SGOReportType reportType, int invocationId, String target, int type) {
        this.taskId = taskId;
        this.reportType = reportType;
        this.invocationId = invocationId;
        this.target = target;
        this.type = type;
    }

    public SGOSubmitReportTask(int taskId, SGOReportType reportType) {
        this.taskId = taskId;
        this.reportType = reportType;
    }

    public SGOSubmitReportTask() {
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.GET;
    }

    @Override
    public String endpoint() {
        return "";
    }

    @Override
    public String params() {
        JsonObject payload = new JsonObject();
        JsonArray args = new JsonArray();
        args.add(taskId);
        args.add(reportType.getName());
        payload.add("arguments", args);

        payload.addProperty("invocationId", String.valueOf(invocationId));
        payload.addProperty("target", target);
        payload.addProperty("type", type);

        return Globals.GSON.toJson(payload) + "\u001E";
    }

    @Override
    public String contentType() {
        return "application/json";
    }

    @Override
    public Map<String, String> headers() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Sec-Websocket-Extensions", "permessage-deflate; client_max_window_bits");
        headers.put("Sec-Websocket-Key", "EH8TRjsB6pTO7hAxQzDMdA==");
        headers.put("Sec-Websocket-Version", "13");

        return headers;
    }

    @Override
    public TypeToken<?> responseType() {
        return new TypeToken<>() {
        };
    }
}