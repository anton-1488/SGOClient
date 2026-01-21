package org.plovdev.sgo.utils;

import org.plovdev.sgo.SGOSession;

import java.util.Timer;
import java.util.TimerTask;

public class SGOSessionRefresher {
    private final Timer timer = new Timer();
    private SGOSession session;

    public SGOSessionRefresher(SGOSession session) {
        this.session = session;
    }

    public SGOSessionRefresher() {
    }

    public SGOSession getSession() {
        return session;
    }

    public void setSession(SGOSession session) {
        this.session = session;
    }

    public void startRefreshLoop() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // TODO: Запрос на обновление токена
                String newToken = "";
                session.getSgoLogin().setAt(newToken);
            }
        }, session.getSgoLogin().getTimeOut());
    }

    public void stopRefreshLoop() {
        timer.cancel();
    }
}