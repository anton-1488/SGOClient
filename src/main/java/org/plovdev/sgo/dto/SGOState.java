package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class SGOState implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("mailMessagesUnreadCount")
    private int mailMessagesUnreadCount;

    @SerializedName("mailError")
    private String mailError;

    @SerializedName("activeSessionsCount")
    private int activeSessionsCount;
    //TODO: notification list


    public SGOState(int mailMessagesUnreadCount, String mailError, int activeSessionsCount) {
        this.mailMessagesUnreadCount = mailMessagesUnreadCount;
        this.mailError = mailError;
        this.activeSessionsCount = activeSessionsCount;
    }

    public SGOState() {
    }

    public int getMailMessagesUnreadCount() {
        return mailMessagesUnreadCount;
    }

    public void setMailMessagesUnreadCount(int mailMessagesUnreadCount) {
        this.mailMessagesUnreadCount = mailMessagesUnreadCount;
    }

    public String getMailError() {
        return mailError;
    }

    public void setMailError(String mailError) {
        this.mailError = mailError;
    }

    public int getActiveSessionsCount() {
        return activeSessionsCount;
    }

    public void setActiveSessionsCount(int activeSessionsCount) {
        this.activeSessionsCount = activeSessionsCount;
    }

    @Override
    public String toString() {
        return "SGOState{" +
                "mailMessagesUnreadCount=" + mailMessagesUnreadCount +
                ", mailError='" + mailError + '\'' +
                ", activeSessionsCount=" + activeSessionsCount +
                '}';
    }
}