package org.plovdev.sgo.reports.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class ReportCreated implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("taskId")
    private int taskId;

    @SerializedName("data")
    private String data;

    @SerializedName("componentId")
    private UUID componentId;

    public ReportCreated(int taskId, String data, String componentId) {
        this.taskId = taskId;
        this.data = data;
        this.componentId = UUID.fromString(componentId);
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public UUID getComponentId() {
        return componentId;
    }

    public void setComponentId(UUID componentId) {
        this.componentId = componentId;
    }

    @Override
    public String toString() {
        return "ReportCreated{" +
                "taskId=" + taskId +
                ", data='" + data + '\'' +
                ", componentId=" + componentId +
                '}';
    }
}