import org.plovdev.sgo.ClientRole;
import org.plovdev.sgo.SGOClient;
import org.plovdev.sgo.SGOSession;
import org.plovdev.sgo.dto.SGODiary;
import org.plovdev.sgo.dto.School;
import org.plovdev.sgo.http.requests.GetSGODiary;
import org.plovdev.sgo.security.AuthKeys;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try (SGOClient client = new SGOClient(new AuthKeys("ПавловАА157", "1431190s"))) {
            SGOSession session = client.createSession(School.MAOU6, ClientRole.STUDENT);
            System.out.println(session);

            SGODiary diary = client.execute(new GetSGODiary(LocalDate.now().minusWeeks(1), LocalDate.now(), session.getSgoContext().getYearId()));
            System.out.println(diary);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}