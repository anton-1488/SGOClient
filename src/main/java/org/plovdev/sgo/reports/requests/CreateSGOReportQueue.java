package org.plovdev.sgo.reports.requests;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;
import org.plovdev.sgo.http.requests.SGORequest;
import org.plovdev.sgo.reports.dto.ReportFilter;
import org.plovdev.sgo.reports.dto.SGOReportQueue;
import org.plovdev.sgo.utils.Pair;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import static org.plovdev.sgo.utils.Globals.GSON;

public class CreateSGOReportQueue extends SGORequest<SGOReportQueue> {
    public List<ReportFilter> filters;
    private List<Pair> params;

    public CreateSGOReportQueue(List<ReportFilter> filters, List<Pair> params) {
        this.filters = filters;
        this.params = params;
    }

    public CreateSGOReportQueue() {
    }

    public List<ReportFilter> getFilters() {
        return filters;
    }

    public void setFilters(List<ReportFilter> filters) {
        this.filters = filters;
    }

    public List<Pair> getParams() {
        return params;
    }

    public void setParams(List<Pair> params) {
        this.params = params;
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.POST;
    }

    @Override
    public String endpoint() {
        return SGOHttpPath.REPORT_QUEUE;
    }

    @Override
    public String params() {
        return GSON.toJson(preparePayload());
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
        return new TypeToken<SGOReportQueue>(){}.getType();
    }

    private JsonObject preparePayload() {
        JsonObject payload = new JsonObject();

        // 1. selectedData (массив фильтров)
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

        // 2. params (дополнительные параметры)
        JsonArray paramsArray = new JsonArray();
        if (params != null) {
            for (Pair pair : params) {
                JsonObject paramObj = new JsonObject();
                paramObj.addProperty("name", pair.getName());

                Object value = pair.getValue();
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