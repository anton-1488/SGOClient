package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class SGOLesson implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("SGOAssignments")
    private List<SGOAssignment> SGOAssignments;

    @SerializedName("isDistanceLesson")
    private boolean isDistanceLesson;

    @SerializedName("isEaLesson")
    private boolean isEaLesson;

    @SerializedName("classmeetingId")
    private long classmeetingId;

    @SerializedName("day")
    private LocalDate day;

    @SerializedName("number")
    private int number;

    @SerializedName("relay")
    private int relay;

    @SerializedName("room")
    private String room;

    @SerializedName("startTime")
    private LocalTime startTime;

    @SerializedName("endTime")
    private LocalTime endTime;

    @SerializedName("subjectName")
    private String subjectName;

    public SGOLesson(List<SGOAssignment> SGOAssignments, boolean isDistanceLesson, boolean isEaLesson, long classmeetingId, LocalDate day, int number, int relay, String room, LocalTime startTime, LocalTime endTime, String subjectName) {
        this.SGOAssignments = SGOAssignments;
        this.isDistanceLesson = isDistanceLesson;
        this.isEaLesson = isEaLesson;
        this.classmeetingId = classmeetingId;
        this.day = day;
        this.number = number;
        this.relay = relay;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
        this.subjectName = subjectName;
    }

    public SGOLesson() {
    }

    public List<SGOAssignment> getAssignments() {
        return SGOAssignments;
    }

    public void setAssignments(List<SGOAssignment> SGOAssignments) {
        this.SGOAssignments = SGOAssignments;
    }

    public boolean isDistanceLesson() {
        return isDistanceLesson;
    }

    public void setDistanceLesson(boolean distanceLesson) {
        isDistanceLesson = distanceLesson;
    }

    public boolean isEaLesson() {
        return isEaLesson;
    }

    public void setEaLesson(boolean eaLesson) {
        isEaLesson = eaLesson;
    }

    public long getClassmeetingId() {
        return classmeetingId;
    }

    public void setClassmeetingId(long classmeetingId) {
        this.classmeetingId = classmeetingId;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRelay() {
        return relay;
    }

    public void setRelay(int relay) {
        this.relay = relay;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "SGOLesson{" +
                "SGOAssignments=" + SGOAssignments +
                ", isDistanceLesson=" + isDistanceLesson +
                ", isEaLesson=" + isEaLesson +
                ", classmeetingId=" + classmeetingId +
                ", day=" + day +
                ", number=" + number +
                ", relay=" + relay +
                ", room='" + room + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}