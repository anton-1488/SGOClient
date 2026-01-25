import com.google.gson.reflect.TypeToken;
import org.plovdev.sgo.ClientRole;
import org.plovdev.sgo.SGOClient;
import org.plovdev.sgo.SGOSession;
import org.plovdev.sgo.dto.SGOReport;
import org.plovdev.sgo.dto.School;
import org.plovdev.sgo.reports.SGOReportSettings;
import org.plovdev.sgo.reports.SGOReportType;
import org.plovdev.sgo.reports.SGOReports;
import org.plovdev.sgo.reports.dto.ReportFilter;
import org.plovdev.sgo.security.AuthKeys;
import org.plovdev.sgo.utils.Pair;

import java.util.*;

import static org.plovdev.sgo.utils.Globals.GSON;

public class Main {
    public static void main(String[] args) {
        try (SGOClient client = new SGOClient(new AuthKeys("ПавловАА157", "1431190s"))) {
            SGOSession session = client.createSession(School.MAOU6, ClientRole.STUDENT);

            ArrayList<ReportFilter> filters = GSON.fromJson(json, new TypeToken<List<ReportFilter>>(){}.getType());

            List<Pair> pairs = new ArrayList<>();
            pairs.add(new Pair("SCHOOLYEARID", "91715"));
            pairs.add(new Pair("SERVERTIMEZONE", 3));
            pairs.add(new Pair("FULLSCHOOLNAME", "Муниципальное автономное общеобразовательное учреждение \"Средняя школа №6\" городского округа город Урюпинск Волгоградской области"));
            pairs.add(new Pair("DATEFORMAT", "d\u0001mm\u0001yy\u0001."));

            SGOReports reports = new SGOReports(client);
            SGOReport report = reports.createReport(new SGOReportSettings(filters, pairs, SGOReportType.STUDENT_ATTENDANCE));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static final String json = """
            [
                    {
                        "filterId": "SID",
                        "filterValue": "1870886",
                        "filterText": "Павлов Антон"
                    },
                    {
                        "filterId": "PCLID",
                        "filterValue": "458655",
                        "filterText": "8а"
                    },
                    {
                        "filterId": "TERMID",
                        "filterValue": "145281",
                        "filterText": "3 четверть"
                    },
                    {
                        "filterId": "period",
                        "filterValue": "2026-01-12T00:00:00.000Z - 2026-03-29T00:00:00.000Z",
                        "filterText": "12.01.2026 - 29.03.2026"
                    }
            ]
            """;
}