package org.plovdev.sgoclient.example;

import org.plovdev.sgoclient.core.SGOClient;
import org.plovdev.sgoclient.core.dto.Schools;
import org.plovdev.sgoclient.core.reports.dto.SGOReport;
import org.plovdev.sgoclient.core.security.AuthKeys;
import org.plovdev.sgoclient.reports.SGOReportCreator;
import org.plovdev.sgoclient.reports.dto.ReportFilter;
import org.plovdev.sgoclient.reports.dto.requests.JournalAccessReportRequest;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        try (SGOClient client = new SGOClient(new AuthKeys("ПавловАА157", "1431190s"))) {
            client.createSession(Schools.MAOU6);
            LocalDateTime now = LocalDateTime.now();

            ReportFilter filter1 = ReportFilter.userFilter("1870886", "Павлов Антон");
            ReportFilter filter2 = ReportFilter.classIUPFilter("458655", "8а");
            ReportFilter filter3 = ReportFilter.termFilter("145282", "4 четверть");
            ReportFilter filter4 = ReportFilter.periodFilter(now.minusMonths(2), now);

            SGOReportCreator creator = new SGOReportCreator(client);
            SGOReport report = creator.createReport(new JournalAccessReportRequest(filter2));
            System.out.println(report);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}