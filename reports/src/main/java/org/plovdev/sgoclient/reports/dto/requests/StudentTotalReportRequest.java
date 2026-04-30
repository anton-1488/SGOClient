package org.plovdev.sgoclient.reports.dto.requests;

import org.plovdev.sgoclient.core.reports.SGOReportOutputType;
import org.plovdev.sgoclient.core.reports.SGOReportType;
import org.plovdev.sgoclient.reports.dto.ReportFilter;

import java.util.List;

public class StudentTotalReportRequest extends SGOReportRequest {
    public StudentTotalReportRequest(SGOReportOutputType outputType, ReportFilter userFilter, ReportFilter classFilter, ReportFilter termFilter, ReportFilter periodFilter) {
        super(SGOReportType.STUDENT_TOTAL, outputType, List.of(userFilter, classFilter, termFilter, periodFilter));
    }

    public StudentTotalReportRequest(ReportFilter userFilter, ReportFilter classFilter, ReportFilter termFilter, ReportFilter periodFilter) {
        super(SGOReportType.STUDENT_TOTAL, SGOReportOutputType.HTML, List.of(userFilter, classFilter, termFilter, periodFilter));
    }
}