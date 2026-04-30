package org.plovdev.sgoclient.reports.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class ReportCreatingProgress implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("taskId")
    private int taskId;

    @SerializedName("status")
    private String status;

    @SerializedName("details")
    private String details;

    public ReportCreatingProgress(int taskId, String status, String details) {
        this.taskId = taskId;
        this.status = status;
        this.details = details;
    }

    public ReportCreatingProgress() {
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ReportCreatingProgress{" +
                "taskId=" + taskId +
                ", status='" + status + '\'' +
                '}';
    }
}