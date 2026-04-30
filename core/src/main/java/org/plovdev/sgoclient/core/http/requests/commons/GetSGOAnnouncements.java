package org.plovdev.sgoclient.core.http.requests.commons;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgoclient.core.dto.SGOAnnouncement;
import org.plovdev.sgoclient.core.http.HttpMethod;
import org.plovdev.sgoclient.core.http.SGOHttpPath;
import org.plovdev.sgoclient.core.http.requests.SGORequest;

import java.util.List;
import java.util.Map;

public class GetSGOAnnouncements extends SGORequest<List<SGOAnnouncement>> {
    private int take = -1;

    public GetSGOAnnouncements(int take) {
        this.take = take;
    }

    public GetSGOAnnouncements() {
    }

    public int getTake() {
        return take;
    }

    public void setTake(int take) {
        this.take = take;
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.GET;
    }

    @Override
    public String endpoint() {
        return SGOHttpPath.ANNOUNCEMENTS;
    }

    @Override
    public String params() {
        return "?take=" + take;
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
    public TypeToken<List<SGOAnnouncement>> responseType() {
        return new TypeToken<>() {
        };
    }
}