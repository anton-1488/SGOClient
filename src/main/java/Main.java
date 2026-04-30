import org.plovdev.sgo.SGOClient;
import org.plovdev.sgo.dto.SGOContext;
import org.plovdev.sgo.dto.Schools;
import org.plovdev.sgo.http.requests.commons.GetSGOContext;
import org.plovdev.sgo.security.AuthKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try (SGOClient client = new SGOClient(AuthKeys.load("MY_NAME", "MY_PASS"))) {
            client.createSession(Schools.MAOU6);
            System.out.println((SGOContext) client.execute(new GetSGOContext()));
        } catch (Exception e) {
            log.error("<error>: ", e);
        }
    }
}