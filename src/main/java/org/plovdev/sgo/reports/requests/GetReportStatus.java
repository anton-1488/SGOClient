package org.plovdev.sgo.reports.requests;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;
import org.plovdev.sgo.http.requests.SGORequest;
import org.plovdev.sgo.reports.dto.ReportStatus;

import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class GetReportStatus extends SGORequest<ReportStatus> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy HH:mm:ss 'GMT' XX", Locale.ENGLISH);
    private String at;
    private String connectionId;

    public GetReportStatus(String at, String connectionId) {
        this.at = at;
        this.connectionId = connectionId;
    }

    public GetReportStatus() {
    }

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.GET;
    }

    @Override
    public String endpoint() {
        ZonedDateTime time = ZonedDateTime.now(ZoneId.of("Europe/Volgograd"));
        return SGOHttpPath.REPORT_TASK + String.format("?at=%s&id=%s&_=%s", at, connectionId, URLEncoder.encode((time.format(formatter) + " (Волгоград, стандартное время)"), StandardCharsets.UTF_8));
    }

    @Override
    public String params() {
        return "";
    }

    @Override
    public String contentType() {
        return "text/plain;charset=UTF-8";
    }

    @Override
    public Map<String, String> headers() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("X-SignalR-User-Agent",
                "Microsoft SignalR/5.0 (5.0.11; Unknown OS; Browser; Unknown Runtime Version)");
        return headers;
    }

    @Override
    public Type responseType() {
        return new TypeToken<ReportStatus>(){}.getType();
    }
}