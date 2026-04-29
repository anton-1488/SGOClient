package org.plovdev.sgo.reports.requests;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;
import org.plovdev.sgo.http.requests.SGORequest;

import java.util.Map;

public class LoadSGOReportRequest extends SGORequest<byte[]> {
    private String fileId;

    public LoadSGOReportRequest(String fileId) {
        this.fileId = fileId;
    }

    public LoadSGOReportRequest() {
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.GET;
    }

    @Override
    public String endpoint() {
        return SGOHttpPath.FILES + fileId;
    }

    @Override
    public String params() {
        return "";
    }

    @Override
    public String contentType() {
        return "*/*";
    }

    @Override
    public Map<String, String> headers() {
        return Map.of();
    }

    @Override
    public TypeToken<byte[]> responseType() {
        return new TypeToken<>() {
        };
    }
}
