package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class School implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public static School MAOU6 = new School("МАОУ \"СШ №6\"", 130);

    @SerializedName("name")
    private String schoolName;

    @SerializedName("id")
    private int schoolId;

    public School(String schoolName, int schoolId) {
        this.schoolName = schoolName;
        this.schoolId = schoolId;
    }

    public School() {
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public static School getMAOU6() {
        return MAOU6;
    }

    public static void setMAOU6(School MAOU6) {
        School.MAOU6 = MAOU6;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolName='" + schoolName + '\'' +
                ", scid=" + schoolId +
                '}';
    }
}