import org.plovdev.sgo.ClientRole;
import org.plovdev.sgo.SGOClient;
import org.plovdev.sgo.SGOSession;
import org.plovdev.sgo.dto.SGOSchedule;
import org.plovdev.sgo.dto.School;
import org.plovdev.sgo.http.requests.GetSGOSchedule;
import org.plovdev.sgo.security.AuthKeys;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (SGOClient client = new SGOClient(new AuthKeys("ПавловАА157", "1431190s"))) {
            SGOSession session = client.createSession(School.MAOU6, ClientRole.STUDENT);

            List<SGOSchedule> schedule = client.execute(new GetSGOSchedule("458655_0"));
            schedule.forEach(s -> System.out.println(s.getName()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}