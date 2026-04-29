import org.plovdev.sgo.SGOClient;
import org.plovdev.sgo.dto.Schools;
import org.plovdev.sgo.reports.SGOReportCreator;
import org.plovdev.sgo.reports.SGOReportOutputType;
import org.plovdev.sgo.reports.dto.ReportFilter;
import org.plovdev.sgo.reports.dto.SGOReport;
import org.plovdev.sgo.reports.dto.StudentTotalReportRequest;
import org.plovdev.sgo.security.AuthKeys;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try (SGOClient client = new SGOClient(new AuthKeys("ПавловАА157", "1431190s"))) {
            client.createSession(Schools.MAOU6);

            List<ReportFilter> filters = new ArrayList<>();
            filters.add(new ReportFilter("SID", "1870886", "Павлов Антон"));
            filters.add(new ReportFilter("PCLID", "458655", "8а"));
            filters.add(new ReportFilter("TERMID", "145282", "4 четверть"));
            filters.add(new ReportFilter("period", "2026-03-30T00:00:00.000Z - 2026-05-25T00:00:00.000Z", "30.03.2026 - 25.05.2026"));

            Map<String, Object> params = new LinkedHashMap<>();
            params.put("SCHOOLYEARID", "91715");
            params.put("SERVERTIMEZONE", 3);
            params.put("FULLSCHOOLNAME", "Муниципальное автономное общеобразовательное учреждение \"Средняя школа №6\" городского округа город Урюпинск Волгоградской области");
            params.put("DATEFORMAT", "d\u0001mm\u0001yy\u0001.");

            SGOReportCreator creator = new SGOReportCreator(client);
            SGOReport report = creator.createReport(new StudentTotalReportRequest(SGOReportOutputType.HTML, filters, params));
            System.out.println(report);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}