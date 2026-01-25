package org.plovdev.sgo.reports.requests;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;
import org.plovdev.sgo.http.requests.SGORequest;

import java.lang.reflect.Type;
import java.util.Map;

public class EarlyAccessRequest extends SGORequest<Boolean> {
    private String accessKey;

    public EarlyAccessRequest(String accessKey) {
        this.accessKey = accessKey;
    }

    public EarlyAccessRequest() {
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.GET;
    }

    @Override
    public String endpoint() {
        return SGOHttpPath.EARLY_ACCESS + "?accessKey=" + accessKey;
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