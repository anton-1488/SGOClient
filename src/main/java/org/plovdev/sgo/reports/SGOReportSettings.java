package org.plovdev.sgo.reports;

import org.plovdev.sgo.reports.dto.ReportFilter;
import org.plovdev.sgo.utils.Pair;

import java.util.List;

public class SGOReportSettings {
    private List<ReportFilter> filters;
    private List<Pair> params;
    private SGOReportType reportType;

    public SGOReportSettings(List<ReportFilter> filters, List<Pair> params, SGOReportType reportType) {
        this.filters = filters;
        this.params = params;
        this.reportType = reportType;
    }

    public SGOReportSettings() {
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

    public SGOReportType getReportType() {
        return reportType;
    }

    public void setReportType(SGOReportType reportType) {
        this.reportType = reportType;
    }
}