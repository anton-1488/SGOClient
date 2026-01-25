package org.plovdev.sgo.reports.requests;

import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;
import org.plovdev.sgo.http.requests.SGORequest;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class BreakSignalrPolling extends SGORequest<Void> {
    private String at;
    private String id;

    public BreakSignalrPolling(String at, String id) {
        this.at = at;
        this.id = id;
    }

    public BreakSignalrPolling() {
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.DELETE;
    }

    @Override
    public String endpoint() {
        return SGOHttpPath.REPORT_TASK + String.format("?at=%s&id=%s", at, id);
    }

    @Override
    public String params() {
        return "";
    }

    @Override
    public String contentType() {
        return "text/plain";
    }

    @Override
    public Map<String, String> headers() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("X-SignalR-User-Agent", "Microsoft SignalR/5.0 (5.0.11; Unknown OS; Browser; Unknown Runtime Version)");
        return headers;
    }

    @Override
    public Type responseType() {
        return Void.class;
    }
}