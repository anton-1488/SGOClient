package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class SGOClass implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("grade")
    private int grade;

    @SerializedName("letter")
    private String letter;

    @SerializedName("functType")
    private String functType;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    public SGOClass(int grade, String letter, String functType, int id, String name) {
        this.grade = grade;
        this.letter = letter;
        this.functType = functType;
        this.id = id;
        this.name = name;
    }

    public SGOClass() {
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getFunctType() {
        return functType;
    }

    public void setFunctType(String functType) {
        this.functType = functType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SGOClass{" +
                "grade=" + grade +
                ", letter='" + letter + '\'' +
                ", functType='" + functType + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}