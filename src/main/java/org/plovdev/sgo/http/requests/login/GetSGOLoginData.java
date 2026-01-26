package org.plovdev.sgo.http.requests.login;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgo.dto.SGOLoginData;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;
import org.plovdev.sgo.http.requests.SGORequest;

import java.lang.reflect.Type;
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
    public Type responseType() {
        return new TypeToken<SGOLoginData>(){}.getType();
    }
}