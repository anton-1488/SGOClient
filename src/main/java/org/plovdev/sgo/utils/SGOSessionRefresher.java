package org.plovdev.sgo.utils;

import org.plovdev.sgo.ClientRole;
import org.plovdev.sgo.SGOClient;
import org.plovdev.sgo.SGOSession;
import org.plovdev.sgo.dto.SGOContext;
import org.plovdev.sgo.dto.SGOLogin;
import org.plovdev.sgo.dto.SGOLoginData;
import org.plovdev.sgo.dto.SGOSchool;
import org.plovdev.sgo.http.requests.commons.GetSGOContext;
import org.plovdev.sgo.http.requests.login.GetSGOLoginData;
import org.plovdev.sgo.http.requests.login.SGOLoginRequest;
import org.plovdev.sgo.security.AuthKeys;
import org.plovdev.sgo.security.HashUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SGOSessionRefresher {
    private static final Logger log = LoggerFactory.getLogger(SGOSessionRefresher.class);
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final SGOClient client;
    private volatile boolean running = false;

    public SGOSessionRefresher(SGOClient client) {
        this.client = client;
    }

    public void startRefreshLoop(AuthKeys authKeys, SGOSchool school, ClientRole role) {
        if (running) {
            return;
        }

        long refreshDelay = client.getCurrentSession().getSgoLogin().getTimeOut();
        scheduler.scheduleWithFixedDelay(() -> {
            try {
                SGOLoginData loginData = client.execute(new GetSGOLoginData());
                SGOLoginRequest sgoLoginRequest = new SGOLoginRequest(role.getRole(), authKeys.username(), HashUtils.createPassword(loginData.getSalt(), authKeys.password()), loginData.getLt(), loginData.getVer(), school);
                SGOLogin sgoLogin = client.execute(sgoLoginRequest);

                SGOSession currentSession = client.getCurrentSession();
                SGOContext sgoContext = client.execute(new GetSGOContext());

                currentSession.setLoginData(loginData);
                currentSession.setSgoLogin(sgoLogin);
                currentSession.setSgoContext(sgoContext);
            } catch (Exception e) {
                log.error("Error while refresh session: ", e);
            }
        }, refreshDelay, refreshDelay, TimeUnit.MILLISECONDS);

        scheduler.shutdown();
        running = true;
    }

    public void stopRefreshLoop() {
        if (!running) {
            scheduler.close();
            running = false;
        }
    }
}