package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class SGOCoWorker implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("loginTimeInto")
    private LocalDateTime loginTimeInto;

    @SerializedName("logoutTimeFrom")
    private LocalDateTime logoutTimeFrom;

    @SerializedName("ipAddress")
    private String ipAddress;

    public SGOCoWorker(LocalDateTime loginTimeInto, LocalDateTime logoutTimeFrom, String ipAddress) {
        this.loginTimeInto = loginTimeInto;
        this.logoutTimeFrom = logoutTimeFrom;
        this.ipAddress = ipAddress;
    }

    public SGOCoWorker() {
    }

    public LocalDateTime getLoginTimeInto() {
        return loginTimeInto;
    }

    public void setLoginTimeInto(LocalDateTime loginTimeInto) {
        this.loginTimeInto = loginTimeInto;
    }

    public LocalDateTime getLogoutTimeFrom() {
        return logoutTimeFrom;
    }

    public void setLogoutTimeFrom(LocalDateTime logoutTimeFrom) {
        this.logoutTimeFrom = logoutTimeFrom;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "SGOCoWorker{" +
                "loginTimeInto=" + loginTimeInto +
                ", logoutTimeFrom=" + logoutTimeFrom +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}