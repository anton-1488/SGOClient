package org.plovdev.sgo.http.requests;

import org.plovdev.sgo.dto.SGODiary;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;

import java.lang.reflect.Type;
import java.util.Map;

public class GetSGODiary extends SGORequest<SGODiary> {
    @Override
    public HttpMethod method() {
        return HttpMethod.POST;
    }

    @Override
    public String endpoint() {
        return SGOHttpPath.DIARY + "?schoolId=130&studentId=1870886 &vers=1768844293853&weekEnd=2026-01-25&weekStart=2026-01-19&withLaAssigns=true&yearId=91715";
    }

    @Override
    public String params() {
        return "";
    }

    @Override
    public String contentType() {
        return "";
    }

    @Override
    public Map<String, String> headers() {
        return Map.of();
    }

    @Override
    public Type responseType() {
        return null;
    }

    @Override
    public SGODiary parse(String body) {
        return null;
    }
}