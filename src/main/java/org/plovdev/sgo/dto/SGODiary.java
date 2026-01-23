package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class SGODiary implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("weekStart")
    private LocalDate weekStart;

    @SerializedName("weekEnd")
    private LocalDate weekEnd;

    @SerializedName("termName")
    private String termName;

    @SerializedName("className")
    private String className;

    @SerializedName("SGOWeekDays")
    private List<SGOWeekDay> SGOWeekDays;

    public SGODiary(LocalDate weekStart, LocalDate weekEnd, String termName, String className, List<SGOWeekDay> SGOWeekDays) {
        this.weekStart = weekStart;
        this.weekEnd = weekEnd;
        this.termName = termName;
        this.className = className;
        this.SGOWeekDays = SGOWeekDays;
    }

    public SGODiary() {
    }

    public LocalDate getWeekStart() {
        return weekStart;
    }

    public void setWeekStart(LocalDate weekStart) {
        this.weekStart = weekStart;
    }

    public LocalDate getWeekEnd() {
        return weekEnd;
    }

    public void setWeekEnd(LocalDate weekEnd) {
        this.weekEnd = weekEnd;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<SGOWeekDay> getWeekDays() {
        return SGOWeekDays;
    }

    public void setWeekDays(List<SGOWeekDay> SGOWeekDays) {
        this.SGOWeekDays = SGOWeekDays;
    }

    @Override
    public String toString() {
        return "SGODiary{" +
                "weekStart=" + weekStart +
                ", weekEnd=" + weekEnd +
                ", termName='" + termName + '\'' +
                ", className='" + className + '\'' +
                ", SGOWeekDays=" + SGOWeekDays +
                '}';
    }
}