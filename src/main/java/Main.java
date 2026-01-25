import org.plovdev.sgo.SGOClient;
import org.plovdev.sgo.dto.SGOUserFullInfo;
import org.plovdev.sgo.dto.Schools;
import org.plovdev.sgo.http.requests.GetSGOUserFullInfo;
import org.plovdev.sgo.security.AuthKeys;

public class Main {
    public static void main(String[] args) {
        try (SGOClient client = new SGOClient(new AuthKeys("ПавловАА157", "1431190s"))) {
            client.createSession(Schools.MAOU6);

            SGOUserFullInfo info = client.execute(new GetSGOUserFullInfo());
            System.out.println(info);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}