package org.plovdev.sgoclient.reports.dto.requests;

import org.plovdev.sgoclient.core.reports.SGOReportOutputType;
import org.plovdev.sgoclient.core.reports.SGOReportType;
import org.plovdev.sgoclient.reports.dto.ReportFilter;

import java.util.List;

public class StudentGradesReportRequest extends SGOReportRequest {
    public StudentGradesReportRequest(SGOReportOutputType outputType, ReportFilter userFilter, ReportFilter classFilter, ReportFilter subjectFilter, ReportFilter periodFilter) {
        super(SGOReportType.STUDENT_GRADES, outputType, List.of(userFilter, classFilter, subjectFilter, periodFilter));
    }

    public StudentGradesReportRequest(ReportFilter userFilter, ReportFilter classFilter, ReportFilter subjectFilter, ReportFilter periodFilter) {
        super(SGOReportType.STUDENT_GRADES, SGOReportOutputType.HTML, List.of(userFilter, classFilter, subjectFilter, periodFilter));
    }
}