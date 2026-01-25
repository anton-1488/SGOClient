package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class SGOMark implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("id")
    private int id;

    @SerializedName("mark")
    private int mark;

    @SerializedName("dutyMark")
    private boolean dutyMark;

    @SerializedName("assignmentId")
    private int assignmentId;

    public SGOMark(int id, int mark, boolean dutyMark, int assignmentId) {
        this.id = id;
        this.mark = mark;
        this.dutyMark = dutyMark;
        this.assignmentId = assignmentId;
    }

    public SGOMark() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public boolean isDutyMark() {
        return dutyMark;
    }

    public void setDutyMark(boolean dutyMark) {
        this.dutyMark = dutyMark;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    @Override
    public String toString() {
        return "SGOMark{" +
                "id=" + id +
                ", mark=" + mark +
                ", dutyMark=" + dutyMark +
                ", assignmentId=" + assignmentId +
                '}';
    }
}