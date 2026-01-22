import org.plovdev.sgo.ClientRole;
import org.plovdev.sgo.SGOClient;
import org.plovdev.sgo.SGOSession;
import org.plovdev.sgo.dto.School;
import org.plovdev.sgo.security.AuthKeys;

public class Main {
    public static void main(String[] args) {
        try (SGOClient client = new SGOClient(new AuthKeys("ПавловАА157", "1431190s"))) {
            SGOSession session = client.createSession(School.MAOU6, ClientRole.STUDENT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}