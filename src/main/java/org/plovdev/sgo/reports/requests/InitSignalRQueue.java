package org.plovdev.sgo.reports.requests;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;
import org.plovdev.sgo.http.requests.SGORequest;
import org.plovdev.sgo.reports.dto.SGOReportQueue;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class InitSignalRQueue extends SGORequest<SGOReportQueue> {
    private String at;
    private String connectionId;

    public InitSignalRQueue(String at, String connectionId) {
        this.at = at;
        this.connectionId = connectionId;
    }

    public InitSignalRQueue() {
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.POST;
    }

    @Override
    public String params() {
        return "{\"protocol\":\"json\",\"version\":1}\u001E";
    }

    @Override
    public String contentType() {
        return "text/plain;charset=UTF-8";
    }

    @Override
    public String endpoint() {
        return SGOHttpPath.REPORT_TASK + "?at=" + getAt() + "&id=" + getConnectionId();
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
        return new TypeToken<SGOReportQueue>(){}.getType();
    }
}