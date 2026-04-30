package org.plovdev.sgo.reports.requests.ws;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.requests.SGORequest;
import org.plovdev.sgo.utils.Globals;

import java.util.HashMap;
import java.util.Map;

public class SGOSubmitReportTask extends SGORequest<Void> {
    private int taskId;
    private int invocationId = 0;
    private String target = "startTaskAsync";
    private int type = 1;

    public SGOSubmitReportTask(int taskId, int invocationId, String target, int type) {
        this.taskId = taskId;
        this.invocationId = invocationId;
        this.target = target;
        this.type = type;
    }

    public SGOSubmitReportTask(int taskId) {
        this.taskId = taskId;
    }

    public SGOSubmitReportTask() {
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getInvocationId() {
        return invocationId;
    }

    public void setInvocationId(int invocationId) {
        this.invocationId = invocationId;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
        args.add("report-v2");
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
    public TypeToken<Void> responseType() {
        return new TypeToken<>() {
        };
    }
}