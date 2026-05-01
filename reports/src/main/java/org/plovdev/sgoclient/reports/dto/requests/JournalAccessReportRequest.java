package org.plovdev.sgoclient.reports.dto.requests;

import org.plovdev.sgoclient.reports.SGOReportOutputType;
import org.plovdev.sgoclient.reports.SGOReportType;
import org.plovdev.sgoclient.reports.dto.ReportFilter;

import java.util.List;

public class JournalAccessReportRequest extends SGOReportRequest {
    public JournalAccessReportRequest(SGOReportOutputType outputType, ReportFilter classFilter) {
        super(SGOReportType.JOURNAL_ACCESS, outputType, List.of(classFilter));
    }

    public JournalAccessReportRequest(ReportFilter classFilter) {
        super(SGOReportType.JOURNAL_ACCESS, SGOReportOutputType.HTML, List.of(classFilter));
    }
}