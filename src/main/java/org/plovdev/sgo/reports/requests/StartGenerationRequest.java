package org.plovdev.sgo.reports.requests;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;
import org.plovdev.sgo.http.requests.SGORequest;
import org.plovdev.sgo.reports.SGOReportType;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import static org.plovdev.sgo.utils.Globals.GSON;

public class StartGenerationRequest extends SGORequest<Void> {
    private String at;
    private String id;
    private int taskId;
    private SGOReportType type;

    public StartGenerationRequest(String at, String id, int taskId, SGOReportType type) {
        this.at = at;
        this.id = id;
        this.taskId = taskId;
        this.type = type;
    }

    public StartGenerationRequest() {
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public SGOReportType getType() {
        return type;
    }

    public void setType(SGOReportType type) {
        this.type = type;
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
        return HttpMethod.POST;
    }

    @Override
    public String endpoint() {
        return SGOHttpPath.REPORT_TASK + String.format("?at=%s&id=%s", at, id);
    }

    @Override
    public String params() {
        JsonObject payload = new JsonObject();
        JsonArray args = new JsonArray();
        args.add(taskId);
        args.add(type.getName());
        payload.add("arguments", args);
        payload.addProperty("invocationId", 0);
        payload.addProperty("target", "startTask");
        payload.addProperty("type", 1);

        return GSON.toJson(payload);
    }

    @Override
    public String contentType() {
        return "text/plain";
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
        return Void.class;
    }
}
