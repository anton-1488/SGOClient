package org.plovdev.sgoclient.reports.dto.requests;

import org.plovdev.sgoclient.core.reports.SGOReportOutputType;
import org.plovdev.sgoclient.core.reports.SGOReportType;
import org.plovdev.sgoclient.reports.dto.ReportFilter;

import java.util.List;
import java.util.Map;

public class StudentTotalReportRequest extends SGOReportRequest {
    public StudentTotalReportRequest(SGOReportOutputType outputType, List<ReportFilter> reportFilters, Map<String, Object> params) {
        super(SGOReportType.STUDENT_TOTAL, outputType, reportFilters, params);
    }
}