package org.plovdev.sgoclient.example;

import org.plovdev.sgoclient.core.SGOClient;
import org.plovdev.sgoclient.core.dto.Schools;
import org.plovdev.sgoclient.core.security.AuthKeys;
import org.plovdev.sgoclient.reports.SGOReportCreator;
import org.plovdev.sgoclient.reports.SGOReportOutputType;
import org.plovdev.sgoclient.reports.dto.ReportFilter;
import org.plovdev.sgoclient.reports.dto.SGOReport;
import org.plovdev.sgoclient.reports.dto.requests.StudentTotalReportRequest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        try (SGOClient client = new SGOClient(AuthKeys.load("MY_NAME", "MY_PASS"))) {
            client.createSession(Schools.MAOU6);
            LocalDateTime now = LocalDateTime.now();

            ReportFilter filter1 = ReportFilter.userFilter("1870886");
            ReportFilter filter2 = ReportFilter.classFilter("458655");
            ReportFilter filter3 = ReportFilter.termFilter("145282");
            ReportFilter filter4 = ReportFilter.periodFilter(now.minusMonths(2), now);

            SGOReportCreator creator = new SGOReportCreator(client);
            SGOReport report = creator.createReport(new StudentTotalReportRequest(SGOReportOutputType.HTML, filter1, filter2, filter3, filter4));
            Files.write(Path.of("report.html"), report.getReportBody());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}