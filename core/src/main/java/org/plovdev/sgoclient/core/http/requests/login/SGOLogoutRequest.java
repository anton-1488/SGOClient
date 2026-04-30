package org.plovdev.sgoclient.core.http.requests.login;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgoclient.core.http.HttpMethod;
import org.plovdev.sgoclient.core.http.SGOHttpPath;
import org.plovdev.sgoclient.core.http.requests.SGORequest;

import java.util.Map;

public class SGOLogoutRequest extends SGORequest<Void> {
    private String at;
    private String ver;

    public SGOLogoutRequest(String ver, String at) {
        this.ver = ver;
        this.at = at;
    }

    public SGOLogoutRequest() {
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.POST;
    }

    @Override
    public String endpoint() {
        return SGOHttpPath.LOGUOT;
    }

    @Override
    public String params() {
        return String.format("at=%s&ver=%s", at, ver);
    }

    @Override
    public String contentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override
    public Map<String, String> headers() {
        return Map.of();
    }

    @Override
    public TypeToken<Void> responseType() {
        return new TypeToken<>() {
        };
    }
}
