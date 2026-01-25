package org.plovdev.sgo.reports.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class SGOReportQueue implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("taskId")
    private int taskId;

    @SerializedName("queueKey")
    private String queueKey;

    @SerializedName("activeConnectionExec")
    private boolean activeConnectionExec;

    @SerializedName("cancellable")
    private boolean cancellable;

    public SGOReportQueue(int taskId, String queueKey, boolean activeConnectionExec, boolean cancellable) {
        this.taskId = taskId;
        this.queueKey = queueKey;
        this.activeConnectionExec = activeConnectionExec;
        this.cancellable = cancellable;
    }

    public SGOReportQueue() {
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getQueueKey() {
        return queueKey;
    }

    public void setQueueKey(String queueKey) {
        this.queueKey = queueKey;
    }

    public boolean isActiveConnectionExec() {
        return activeConnectionExec;
    }

    public void setActiveConnectionExec(boolean activeConnectionExec) {
        this.activeConnectionExec = activeConnectionExec;
    }

    public boolean isCancellable() {
        return cancellable;
    }

    public void setCancellable(boolean cancellable) {
        this.cancellable = cancellable;
    }

    @Override
    public String toString() {
        return "SGOReportQueue{" +
                "taskId=" + taskId +
                ", queueKey='" + queueKey + '\'' +
                ", activeConnectionExec=" + activeConnectionExec +
                ", cancellable=" + cancellable +
                '}';
    }
}