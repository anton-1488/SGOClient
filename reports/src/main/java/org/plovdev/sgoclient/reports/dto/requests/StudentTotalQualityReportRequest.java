package org.plovdev.sgoclient.reports.dto.requests;

import org.plovdev.sgoclient.core.reports.SGOReportOutputType;
import org.plovdev.sgoclient.core.reports.SGOReportType;
import org.plovdev.sgoclient.reports.dto.ReportFilter;

import java.util.List;

public class StudentTotalQualityReportRequest extends SGOReportRequest {
    public StudentTotalQualityReportRequest(SGOReportOutputType outputType, ReportFilter userFilter, ReportFilter classFilter, ReportFilter subjectFilter, ReportFilter periodFilter) {
        super(SGOReportType.STUDENT_TOTAL_QUALITY, outputType, List.of(userFilter, classFilter, subjectFilter, periodFilter));
    }

    public StudentTotalQualityReportRequest(ReportFilter userFilter, ReportFilter classFilter, ReportFilter subjectFilter, ReportFilter periodFilter) {
        super(SGOReportType.STUDENT_TOTAL_QUALITY, SGOReportOutputType.HTML, List.of(userFilter, classFilter, subjectFilter, periodFilter));
    }
}