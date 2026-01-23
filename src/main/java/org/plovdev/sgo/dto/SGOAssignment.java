package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class SGOAssignment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("id")
    private int id;

    @SerializedName("typeId")
    private int typeId;

    @SerializedName("assignmentName")
    private String assignmentName;

    @SerializedName("weight")
    private int weight;

    @SerializedName("dueDate")
    private LocalDate dueDate;

    @SerializedName("classAssignment")
    private boolean classAssignment;

    @SerializedName("classMeetingId")
    private long classMeetingId;

    @SerializedName("issueClassMeetingId")
    private long issueClassMeetingId;

    public SGOAssignment(int id, int typeId, String assignmentName, int weight, LocalDate dueDate, boolean classAssignment, long classMeetingId, long issueClassMeetingId) {
        this.id = id;
        this.typeId = typeId;
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.dueDate = dueDate;
        this.classAssignment = classAssignment;
        this.classMeetingId = classMeetingId;
        this.issueClassMeetingId = issueClassMeetingId;
    }

    public SGOAssignment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isClassAssignment() {
        return classAssignment;
    }

    public void setClassAssignment(boolean classAssignment) {
        this.classAssignment = classAssignment;
    }

    public long getClassMeetingId() {
        return classMeetingId;
    }

    public void setClassMeetingId(long classMeetingId) {
        this.classMeetingId = classMeetingId;
    }

    public long getIssueClassMeetingId() {
        return issueClassMeetingId;
    }

    public void setIssueClassMeetingId(long issueClassMeetingId) {
        this.issueClassMeetingId = issueClassMeetingId;
    }

    @Override
    public String toString() {
        return "SGOAssignment{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                ", dueDate=" + dueDate +
                ", classAssignment=" + classAssignment +
                ", classMeetingId=" + classMeetingId +
                ", issueClassMeetingId=" + issueClassMeetingId +
                '}';
    }
}