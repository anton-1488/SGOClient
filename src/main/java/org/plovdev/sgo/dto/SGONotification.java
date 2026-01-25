package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class SGONotification implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("type")
    private String name;

    @SerializedName("data")
    private SGONotificationData notificationData;

    public SGONotification(String name, SGONotificationData notificationData) {
        this.name = name;
        this.notificationData = notificationData;
    }

    public SGONotification() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SGONotificationData getNotificationData() {
        return notificationData;
    }

    public void setNotificationData(SGONotificationData notificationData) {
        this.notificationData = notificationData;
    }

    @Override
    public String toString() {
        return "SGONotification{" +
                "name='" + name + '\'' +
                ", notificationData=" + notificationData +
                '}';
    }
}