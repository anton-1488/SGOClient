package org.plovdev.sgoclient.core.http.requests.user;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgoclient.core.dto.SGOUserSettings;
import org.plovdev.sgoclient.core.http.HttpMethod;
import org.plovdev.sgoclient.core.http.SGOHttpPath;
import org.plovdev.sgoclient.core.http.requests.SGORequest;

import java.util.Map;

public class GetSGOUserSettings extends SGORequest<SGOUserSettings> {
    private int userId;

    public GetSGOUserSettings(int userId) {
        this.userId = userId;
    }

    public GetSGOUserSettings() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.GET;
    }

    @Override
    public String endpoint() {
        return SGOHttpPath.USER_SETTINGS + "?userId=" + userId;
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
    public TypeToken<SGOUserSettings> responseType() {
        return new TypeToken<>() {
        };
    }
}