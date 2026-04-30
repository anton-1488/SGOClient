package org.plovdev.sgoclient.core.http.requests.commons;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgoclient.core.dto.SGOContext;
import org.plovdev.sgoclient.core.http.HttpMethod;
import org.plovdev.sgoclient.core.http.SGOHttpPath;
import org.plovdev.sgoclient.core.http.requests.SGORequest;

import java.util.Map;

public class GetSGOContext extends SGORequest<SGOContext> {
    @Override
    public HttpMethod method() {
        return HttpMethod.GET;
    }

    @Override
    public String endpoint() {
        return SGOHttpPath.CONTEXT;
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
    public TypeToken<SGOContext> responseType() {
        return new TypeToken<>() {
        };
    }
}