import org.plovdev.sgo.SGOClient;
import org.plovdev.sgo.dto.SGOSchool;
import org.plovdev.sgo.http.requests.SearchSchools;
import org.plovdev.sgo.security.AuthKeys;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (SGOClient client = new SGOClient(new AuthKeys("ПавловАА157", "1431190s"))) {

            List<SGOSchool> schools = client.execute(new SearchSchools("МАОУ СШ 6"));
            schools.forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}