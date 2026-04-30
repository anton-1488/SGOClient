package org.plovdev.sgo.reports.requests;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.jspecify.annotations.NonNull;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;
import org.plovdev.sgo.http.requests.SGORequest;
import org.plovdev.sgo.reports.SGOReportOutputType;
import org.plovdev.sgo.reports.SGOReportType;
import org.plovdev.sgo.reports.dto.ReportFilter;
import org.plovdev.sgo.reports.dto.SGOReportQueue;

import java.util.List;
import java.util.Map;

import static org.plovdev.sgo.utils.Globals.GSON;

public class CreateSGOReportQueue extends SGORequest<SGOReportQueue> {
    public List<ReportFilter> filters;
    private Map<String, Object> params;
    private SGOReportType reportType;
    private SGOReportOutputType outputType;

    public CreateSGOReportQueue(List<ReportFilter> filters, Map<String, Object> params, SGOReportType reportType, SGOReportOutputType outputType) {
        this.filters = filters;
        this.params = params;
        this.reportType = reportType;
        this.outputType = outputType;
    }

    public CreateSGOReportQueue() {
    }

    public SGOReportType getReportType() {
        return reportType;
    }

    public void setReportType(SGOReportType reportType) {
        this.reportType = reportType;
    }

    public SGOReportOutputType getOutputType() {
        return outputType;
    }

    public void setOutputType(SGOReportOutputType outputType) {
        this.outputType = outputType;
    }

    public List<ReportFilter> getFilters() {
        return filters;
    }

    public void setFilters(List<ReportFilter> filters) {
        this.filters = filters;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.POST;
    }

    @Override
    public String endpoint() {
        String output = "";
        if (outputType == SGOReportOutputType.PDF) {
            output = "?output=Pdf";
        }
        return SGOHttpPath.REPORT_QUEUE.replace("{report-type}", reportType.getType()) + output;
    }

    @Override
    public String params() {
        return GSON.toJson(preparePayload());
    }

    @Override
    public String contentType() {
        return "application/json;charset=UTF-8";
    }

    @Override
    public Map<String, String> headers() {
        return Map.of();
    }

    @Override
    public TypeToken<SGOReportQueue> responseType() {
        return new TypeToken<>() {
        };
    }

    private @NonNull JsonObject preparePayload() {
        JsonObject payload = new JsonObject();

        JsonArray selectedData = new JsonArray();
        if (filters != null) {
            for (ReportFilter filter : filters) {
                JsonObject filterObj = new JsonObject();
                filterObj.addProperty("filterId", filter.getFilterId());
                filterObj.addProperty("filterValue", filter.getFilterValue());
                filterObj.addProperty("filterText", filter.getFilterText());
                selectedData.add(filterObj);
            }
        }
        payload.add("selectedData", selectedData);

        JsonArray paramsArray = new JsonArray();
        if (params != null) {
            for (String param : params.keySet()) {
                JsonObject paramObj = new JsonObject();
                paramObj.addProperty("name", param);

                Object value = params.get(param);
                if (value instanceof Number) {
                    paramObj.addProperty("value", (Number) value);
                } else if (value instanceof Boolean) {
                    paramObj.addProperty("value", (Boolean) value);
                } else {
                    paramObj.addProperty("value", value.toString());
                }
                paramsArray.add(paramObj);
            }
        }
        payload.add("params", paramsArray);

        return payload;
    }
}