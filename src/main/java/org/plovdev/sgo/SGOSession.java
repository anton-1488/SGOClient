package org.plovdev.sgo;

import org.plovdev.sgo.dto.SGOContext;
import org.plovdev.sgo.dto.SGOLogin;
import org.plovdev.sgo.dto.SGOLoginData;

public class SGOSession {
    private String cookie;
    private SGOLoginData loginData;
    private SGOLogin sgoLogin;
    private SGOContext sgoContext;

    public SGOSession(String cookie, SGOLoginData loginData, SGOLogin sgoLogin, SGOContext context) {
        this.cookie = cookie;
        this.loginData = loginData;
        this.sgoLogin = sgoLogin;
        sgoContext = context;
    }

    public SGOSession() {
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
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
                "cookie='" + cookie + '\'' +
                ", loginData=" + loginData +
                ", sgoLogin=" + sgoLogin +
                ", sgoContext=" + sgoContext +
                '}';
    }
}