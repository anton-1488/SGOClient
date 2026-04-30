package org.plovdev.sgoclient.reports.dto.requests;

import org.plovdev.sgoclient.core.reports.SGOReportOutputType;
import org.plovdev.sgoclient.core.reports.SGOReportType;
import org.plovdev.sgoclient.reports.dto.ReportFilter;

import java.util.List;

public class FinalGradesReportRequest extends SGOReportRequest {
    public FinalGradesReportRequest(SGOReportOutputType outputType, ReportFilter userFilter, ReportFilter classFilter) {
        super(SGOReportType.FINAL_GRADES, outputType, List.of(userFilter, classFilter));
    }

    public FinalGradesReportRequest(ReportFilter userFilter, ReportFilter classFilter) {
        super(SGOReportType.FINAL_GRADES, SGOReportOutputType.HTML, List.of(userFilter, classFilter));
    }
}