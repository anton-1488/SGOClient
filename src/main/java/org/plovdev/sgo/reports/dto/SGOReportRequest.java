package org.plovdev.sgo.reports.dto;

import com.google.gson.annotations.SerializedName;
import org.plovdev.sgo.reports.SGOReportOutputType;
import org.plovdev.sgo.reports.SGOReportType;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class SGOReportRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("reportType")
    private SGOReportType reportType;

    @SerializedName("outputType")
    private SGOReportOutputType outputType;

    @SerializedName("reportFilters")
    private List<ReportFilter> reportFilters;

    @SerializedName("params")
    private Map<String, Object> params;

    public SGOReportRequest(SGOReportType reportType, SGOReportOutputType outputType, List<ReportFilter> reportFilters, Map<String, Object> params) {
        this.reportType = reportType;
        this.outputType = outputType;
        this.reportFilters = reportFilters;
        this.params = params;
    }

    public SGOReportRequest() {
    }

    public List<ReportFilter> getReportFilters() {
        return reportFilters;
    }

    public void setReportFilters(List<ReportFilter> reportFilters) {
        this.reportFilters = reportFilters;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
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

    @Override
    public String toString() {
        return "SGOReportRequest{" +
                "reportType=" + reportType +
                ", outputType=" + outputType +
                '}';
    }
}