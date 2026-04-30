package org.plovdev.sgoclient.core.http.requests.login;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgoclient.core.http.HttpMethod;
import org.plovdev.sgoclient.core.http.SGOHttpPath;
import org.plovdev.sgoclient.core.http.requests.SGORequest;

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
    public TypeToken<Boolean> responseType() {
        return new TypeToken<>() {
        };
    }
}