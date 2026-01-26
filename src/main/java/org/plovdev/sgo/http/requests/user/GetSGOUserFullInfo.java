package org.plovdev.sgo.http.requests.user;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgo.dto.SGOUserFullInfo;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;
import org.plovdev.sgo.http.requests.SGORequest;

import java.lang.reflect.Type;
import java.util.Map;

public class GetSGOUserFullInfo extends SGORequest<SGOUserFullInfo> {
    @Override
    public HttpMethod method() {
        return HttpMethod.GET;
    }

    @Override
    public String endpoint() {
        return SGOHttpPath.ACCOUNT_FULL_INFO;
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
        return new TypeToken<SGOUserFullInfo>(){}.getType();
    }
}