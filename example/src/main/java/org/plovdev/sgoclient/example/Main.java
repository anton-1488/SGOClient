package org.plovdev.sgoclient.example;

import org.plovdev.sgoclient.core.SGOClient;
import org.plovdev.sgoclient.core.dto.SGOContext;
import org.plovdev.sgoclient.core.dto.Schools;
import org.plovdev.sgoclient.core.http.requests.commons.GetSGOContext;
import org.plovdev.sgoclient.core.security.AuthKeys;
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