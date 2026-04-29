package org.plovdev.sgo.reports.requests.ws;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgo.SGOSession;
import org.plovdev.sgo.dto.SGOLogin;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;
import org.plovdev.sgo.http.requests.SGORequest;
import org.plovdev.sgo.utils.Globals;

import java.util.HashMap;
import java.util.Map;

public class SGONegotinateRequest extends SGORequest<Void> {
    private String at;

    public SGONegotinateRequest(String at) {
        this.at = at;
    }

    public SGONegotinateRequest() {
        SGOSession curr = Globals.getCurrentSession();
        if (curr != null) {
            SGOLogin login = curr.getSgoLogin();
            at = login.getAt();
        }
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
        return SGOHttpPath.REPORT_TASK + String.format("?at=%s", at);
    }

    @Override
    public String params() {
        return "";
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