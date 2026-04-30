package org.plovdev.sgoclient.reports.requests;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.plovdev.sgoclient.core.http.HttpMethod;
import org.plovdev.sgoclient.core.http.SGOHttpPath;
import org.plovdev.sgoclient.core.http.requests.SGORequest;
import org.plovdev.sgoclient.reports.dto.SGOReportQueue;
import org.plovdev.sgoclient.core.utils.Globals;

import java.util.HashMap;
import java.util.Map;

public class InitSignalRQueue extends SGORequest<SGOReportQueue> {
    private String at;
    private String connectionId;
    private static final String protocol = "json";
    private static final int version = 1;

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
        JsonObject payload = new JsonObject();
        payload.addProperty("protocol", protocol);
        payload.addProperty("version", version);
        return Globals.GSON.toJson(payload) + "\u001E";
    }

    @Override
    public String contentType() {
        return "text/plain;charset=UTF-8";
    }

    @Override
    public String endpoint() {
        return SGOHttpPath.REPORT_TASK + "?at=" + getAt() + "&id=" + connectionId;
    }

    @Override
    public Map<String, String> headers() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("X-SignalR-User-Agent", "Microsoft SignalR/5.0 (5.0.11; Unknown OS; Browser; Unknown Runtime Version)");
        return headers;
    }

    @Override
    public TypeToken<SGOReportQueue> responseType() {
        return new TypeToken<>() {
        };
    }
}