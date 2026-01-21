package org.plovdev.sgo;

import org.plovdev.sgo.dto.SGOLogin;
import org.plovdev.sgo.dto.SGOLoginData;

public class SGOSession {
    private String cookie;
    private SGOLoginData loginData;
    private SGOLogin sgoLogin;

    public SGOSession(String cookie, SGOLoginData loginData, SGOLogin sgoLogin) {
        this.cookie = cookie;
        this.loginData = loginData;
        this.sgoLogin = sgoLogin;
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

    @Override
    public String toString() {
        return "SGOSession{" +
                "loginData=" + loginData +
                ", sgoLogin=" + sgoLogin +
                '}';
    }
}