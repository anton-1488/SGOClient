package org.plovdev.sgoclient.reports.dto.requests;

import com.google.gson.annotations.SerializedName;
import org.plovdev.sgoclient.core.reports.SGOReportOutputType;
import org.plovdev.sgoclient.core.reports.SGOReportType;
import org.plovdev.sgoclient.reports.dto.ReportFilter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class SGOReportRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("reportType")
    private SGOReportType reportType;

    @SerializedName("outputType")
    private SGOReportOutputType outputType;

    @SerializedName("reportFilters")
    private List<ReportFilter> reportFilters;

    public SGOReportRequest(SGOReportType reportType, SGOReportOutputType outputType, List<ReportFilter> reportFilters) {
        this.reportType = reportType;
        this.outputType = outputType;
        this.reportFilters = reportFilters;
    }

    public SGOReportRequest() {
    }

    public List<ReportFilter> getReportFilters() {
        return reportFilters;
    }

    public void setReportFilters(List<ReportFilter> reportFilters) {
        this.reportFilters = reportFilters;
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