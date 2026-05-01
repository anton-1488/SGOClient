package org.plovdev.sgoclient.reports.dto.requests;

import org.plovdev.sgoclient.reports.SGOReportOutputType;
import org.plovdev.sgoclient.reports.SGOReportType;
import org.plovdev.sgoclient.reports.dto.ReportFilter;

import java.util.List;

public class ParentInfoReportRequest extends SGOReportRequest {
    public ParentInfoReportRequest(SGOReportOutputType outputType, ReportFilter classFilter, ReportFilter viewTypeFilter, ReportFilter termFilter, ReportFilter userFilter) {
        super(SGOReportType.PARENT_INFO, outputType, List.of(classFilter, viewTypeFilter, termFilter, userFilter));
    }

    public ParentInfoReportRequest(ReportFilter classFilter, ReportFilter viewTypeFilter, ReportFilter termFilter, ReportFilter userFilter) {
        super(SGOReportType.PARENT_INFO, SGOReportOutputType.HTML, List.of(classFilter, viewTypeFilter, termFilter, userFilter));
    }
}