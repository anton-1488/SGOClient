package org.plovdev.sgo.reports.requests;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;
import org.plovdev.sgo.http.requests.SGORequest;
import org.plovdev.sgo.reports.dto.SGONegatiate;

import java.lang.reflect.Type;
import java.util.Map;

public class SGONegotinateRequest extends SGORequest<SGONegatiate> {
    private String at;

    public SGONegotinateRequest(String at) {
        this.at = at;
    }

    public SGONegotinateRequest() {
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.POST;
    }

    @Override
    public String endpoint() {
        return SGOHttpPath.NEGOTINATE + String.format("?at=%s&negotiateVersion=1", at);
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
        return Map.of();
    }

    @Override
    public Type responseType() {
        return new TypeToken<SGONegatiate>(){}.getType();
    }
}