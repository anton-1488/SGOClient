package org.plovdev.sgo.http.requests;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;

import java.lang.reflect.Type;
import java.util.Map;

public class GetSGOTokenExpired extends SGORequest<Boolean> {
    private String at;

    public GetSGOTokenExpired(String at) {
        this.at = at;
    }

    public GetSGOTokenExpired() {
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
        return SGOHttpPath.EXPIRED + "?token=" + at;
    }

    @Override
    public String params() {
        return "";
    }

    @Override
    public String contentType() {
        return "application/json; charset=utf-8";
    }

    @Override
    public Map<String, String> headers() {
        return Map.of();
    }

    @Override
    public Type responseType() {
        return new TypeToken<Boolean>(){}.getType();
    }
}