import org.plovdev.sgo.SGOClient;
import org.plovdev.sgo.SGOSession;
import org.plovdev.sgo.dto.SGODiary;
import org.plovdev.sgo.dto.Schools;
import org.plovdev.sgo.http.requests.user.GetSGODiary;
import org.plovdev.sgo.security.AuthKeys;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try (SGOClient client = new SGOClient(new AuthKeys("ПавловАА157", "1431190s"))) {
            SGOSession sgoSession = client.createSession(Schools.MAOU6);

            SGODiary diary = client.execute(new GetSGODiary(LocalDate.now().minusDays(8), LocalDate.now().minusDays(1), sgoSession.getSgoContext().getUserId(), sgoSession.getSgoContext().getYearId()));
            System.out.println(diary);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}