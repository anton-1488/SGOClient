package org.plovdev.sgoclient.reports.dto.requests;

import org.plovdev.sgoclient.reports.SGOReportOutputType;
import org.plovdev.sgoclient.reports.SGOReportType;
import org.plovdev.sgoclient.reports.dto.ReportFilter;

import java.util.List;

public class DopEducationReportRequest extends SGOReportRequest {
    public DopEducationReportRequest(SGOReportOutputType outputType, ReportFilter userFilter) {
        super(SGOReportType.DOP_EDUCATION, outputType, List.of(userFilter));
    }

    public DopEducationReportRequest(ReportFilter userFilter) {
        super(SGOReportType.DOP_EDUCATION, SGOReportOutputType.HTML, List.of(userFilter));
    }
}