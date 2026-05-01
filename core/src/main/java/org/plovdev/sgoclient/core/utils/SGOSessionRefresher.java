package org.plovdev.sgoclient.core.utils;

import org.plovdev.sgoclient.core.ClientRole;
import org.plovdev.sgoclient.core.SGOClient;
import org.plovdev.sgoclient.core.SGOSession;
import org.plovdev.sgoclient.core.dto.SGOLoginData;
import org.plovdev.sgoclient.core.dto.SGOSchool;
import org.plovdev.sgoclient.core.http.requests.login.GetSGOLoginData;
import org.plovdev.sgoclient.core.http.requests.login.SGOLoginRequest;
import org.plovdev.sgoclient.core.security.AuthKeys;
import org.plovdev.sgoclient.core.security.HashUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SGOSessionRefresher {
    private static final Logger log = LoggerFactory.getLogger(SGOSessionRefresher.class);
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(r -> {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    });

    private final SGOClient client;
    private volatile boolean running = false;

    public SGOSessionRefresher(SGOClient client) {
        this.client = client;
    }

    public synchronized void startRefreshLoop(AuthKeys authKeys, SGOSchool school, ClientRole role) {
        if (running) {
            return;
        }

        long refreshDelay = client.getCurrentSession().getSgoLogin().getTimeOut();
        scheduler.scheduleWithFixedDelay(() -> {
            try {
                SGOLoginData loginData = client.execute(new GetSGOLoginData());
                SGOLoginRequest sgoLoginRequest = new SGOLoginRequest(role.getRole(), authKeys.username(), HashUtils.createPassword(loginData.getSalt(), authKeys.password()), loginData.getLt(), loginData.getVer(), school);

                SGOSession currentSession = client.getCurrentSession();
                currentSession.setLoginData(loginData);
                currentSession.setSgoLogin(client.execute(sgoLoginRequest));
            } catch (Exception e) {
                log.error("Error while refresh session: ", e);
            }
        }, refreshDelay, refreshDelay, TimeUnit.MILLISECONDS);
        running = true;
    }

    public synchronized void stopRefreshLoop() {
        if (running) {
            scheduler.close();
            running = false;
        }
    }
}