package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class SGOState implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("mailMessagesUnreadCount")
    private int mailMessagesUnreadCount;

    @SerializedName("mailError")
    private String mailError;

    @SerializedName("activeSessionsCount")
    private int activeSessionsCount;

    @SerializedName("notifications")
    private List<SGONotification> notifications;


    public SGOState(int mailMessagesUnreadCount, String mailError, int activeSessionsCount, List<SGONotification> notifications) {
        this.mailMessagesUnreadCount = mailMessagesUnreadCount;
        this.mailError = mailError;
        this.activeSessionsCount = activeSessionsCount;
        this.notifications = notifications;
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

    public List<SGONotification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<SGONotification> notifications) {
        this.notifications = notifications;
    }

    @Override
    public String toString() {
        return "SGOState{" +
                "mailMessagesUnreadCount=" + mailMessagesUnreadCount +
                ", mailError='" + mailError + '\'' +
                ", activeSessionsCount=" + activeSessionsCount +
                ", notifications=" + notifications +
                '}';
    }
}