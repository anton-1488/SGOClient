package org.plovdev.sgoclient.reports.dto.requests;

import org.plovdev.sgoclient.core.reports.SGOReportOutputType;
import org.plovdev.sgoclient.core.reports.SGOReportType;
import org.plovdev.sgoclient.reports.dto.ReportFilter;

import java.util.List;

public class AverageMarkReportRequest extends SGOReportRequest {
    public AverageMarkReportRequest(SGOReportOutputType outputType, ReportFilter userFilter, ReportFilter markTypeFilter, ReportFilter classFilter, ReportFilter termFilter, ReportFilter periodFilter) {
        super(SGOReportType.AVERAGE_MARK, outputType, List.of(userFilter, markTypeFilter, classFilter, termFilter, periodFilter));
    }

    public AverageMarkReportRequest(ReportFilter userFilter, ReportFilter markTypeFilter, ReportFilter classFilter, ReportFilter termFilter, ReportFilter periodFilter) {
        super(SGOReportType.AVERAGE_MARK, SGOReportOutputType.HTML, List.of(userFilter, markTypeFilter, classFilter, termFilter, periodFilter));
    }
}