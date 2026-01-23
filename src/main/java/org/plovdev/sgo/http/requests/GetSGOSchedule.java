package org.plovdev.sgo.http.requests;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgo.dto.SGOSchedule;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class GetSGOSchedule extends SGORequest<List<SGOSchedule>> {
    private String iupClassId;

    public GetSGOSchedule(String iupClassId) {
        this.iupClassId = iupClassId;
    }

    public GetSGOSchedule() {
    }

    public String getIupClassId() {
        return iupClassId;
    }

    public void setIupClassId(String iupClassId) {
        this.iupClassId = iupClassId;
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.GET;
    }

    @Override
    public String endpoint() {
        return SGOHttpPath.SCHEDULE + "?iupClassId=" + iupClassId;
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
        return new TypeToken<List<SGOSchedule>>(){}.getType();
    }
}