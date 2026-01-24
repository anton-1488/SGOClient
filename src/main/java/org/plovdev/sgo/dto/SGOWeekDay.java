package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class SGOWeekDay implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("date")
    private LocalDate day;

    @SerializedName("lessons")
    private List<SGOLesson> SGOLessons;

    public SGOWeekDay(LocalDate day, List<SGOLesson> SGOLessons) {
        this.day = day;
        this.SGOLessons = SGOLessons;
    }

    public SGOWeekDay() {
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public List<SGOLesson> getLessons() {
        return SGOLessons;
    }

    public void setLessons(List<SGOLesson> SGOLessons) {
        this.SGOLessons = SGOLessons;
    }

    @Override
    public String toString() {
        return "SGOWeekDay{" +
                "day=" + day +
                ", SGOLessons=" + SGOLessons +
                '}';
    }
}