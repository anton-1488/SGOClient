package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class SGONotificationData implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("loginName")
    private String loginName;

    @SerializedName("nickName")
    private String nickName;

    @SerializedName("warnType")
    private String warnType;

    @SerializedName("coWorkers")
    private List<SGOCoWorker> coWorkers;

    public SGONotificationData(String loginName, String nickName, String warnType, List<SGOCoWorker> coWorkers) {
        this.loginName = loginName;
        this.nickName = nickName;
        this.warnType = warnType;
        this.coWorkers = coWorkers;
    }

    public SGONotificationData() {
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getWarnType() {
        return warnType;
    }

    public void setWarnType(String warnType) {
        this.warnType = warnType;
    }

    public List<SGOCoWorker> getCoWorkers() {
        return coWorkers;
    }

    public void setCoWorkers(List<SGOCoWorker> coWorkers) {
        this.coWorkers = coWorkers;
    }

    @Override
    public String toString() {
        return "SGONotificationData{" +
                "loginName='" + loginName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", warnType='" + warnType + '\'' +
                ", coWorkers=" + coWorkers +
                '}';
    }
}