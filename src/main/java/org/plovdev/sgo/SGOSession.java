package org.plovdev.sgo;

import org.plovdev.sgo.dto.SGOContext;
import org.plovdev.sgo.dto.SGOLogin;
import org.plovdev.sgo.dto.SGOLoginData;

public class SGOSession {
    private SGOLoginData loginData;
    private SGOLogin sgoLogin;
    private SGOContext sgoContext;

    public SGOSession(SGOLoginData loginData, SGOLogin sgoLogin, SGOContext context) {
        this.loginData = loginData;
        this.sgoLogin = sgoLogin;
        sgoContext = context;
    }

    public SGOLoginData getLoginData() {
        return loginData;
    }

    public void setLoginData(SGOLoginData loginData) {
        this.loginData = loginData;
    }

    public SGOLogin getSgoLogin() {
        return sgoLogin;
    }

    public void setSgoLogin(SGOLogin sgoLogin) {
        this.sgoLogin = sgoLogin;
    }

    public SGOContext getSgoContext() {
        return sgoContext;
    }

    public void setSgoContext(SGOContext sgoContext) {
        this.sgoContext = sgoContext;
    }

    @Override
    public String toString() {
        return "SGOSession{" +
                ", loginData=" + loginData +
                ", sgoLogin=" + sgoLogin +
                ", sgoContext=" + sgoContext +
                '}';
    }
}