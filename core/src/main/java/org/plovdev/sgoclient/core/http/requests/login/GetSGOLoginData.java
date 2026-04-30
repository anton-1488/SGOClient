package org.plovdev.sgoclient.core.http.requests.login;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgoclient.core.dto.SGOLoginData;
import org.plovdev.sgoclient.core.http.HttpMethod;
import org.plovdev.sgoclient.core.http.SGOHttpPath;
import org.plovdev.sgoclient.core.http.requests.SGORequest;

import java.util.Map;

public class GetSGOLoginData extends SGORequest<SGOLoginData> {
    @Override
    public HttpMethod method() {
        return HttpMethod.POST;
    }

    @Override
    public String endpoint() {
        return SGOHttpPath.LOGIN_DATA;
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
    public TypeToken<SGOLoginData> responseType() {
        return new TypeToken<>() {
        };
    }
}