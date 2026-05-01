package org.plovdev.sgoclient.reports.dto.requests;

import org.plovdev.sgoclient.reports.SGOReportOutputType;
import org.plovdev.sgoclient.reports.SGOReportType;
import org.plovdev.sgoclient.reports.dto.ReportFilter;

import java.util.List;

public class AverageMarkDynamicReportRequest extends SGOReportRequest {
    public AverageMarkDynamicReportRequest(SGOReportOutputType outputType, ReportFilter userFilter, ReportFilter markTypeFilter, ReportFilter classFilter, ReportFilter termFilter, ReportFilter periodFilter) {
        super(SGOReportType.AVERAGE_MARK, outputType, List.of(userFilter, markTypeFilter, classFilter, termFilter, periodFilter));
    }

    public AverageMarkDynamicReportRequest(ReportFilter userFilter, ReportFilter markTypeFilter, ReportFilter classFilter, ReportFilter termFilter, ReportFilter periodFilter) {
        super(SGOReportType.AVERAGE_MARK, SGOReportOutputType.HTML, List.of(userFilter, markTypeFilter, classFilter, termFilter, periodFilter));
    }
}