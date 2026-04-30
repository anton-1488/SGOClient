package org.plovdev.sgo.reports.dto;

import org.plovdev.sgo.reports.SGOReportOutputType;
import org.plovdev.sgo.reports.SGOReportType;

import java.util.List;
import java.util.Map;

public class StudentTotalReportRequest extends SGOReportRequest {
    public StudentTotalReportRequest(SGOReportOutputType outputType, List<ReportFilter> reportFilters, Map<String, Object> params) {
        super(SGOReportType.STUDENT_TOTAL, outputType, reportFilters, params);
    }
}