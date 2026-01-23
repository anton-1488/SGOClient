package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class SGOScheduleSubject implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("shortName")
    private String shortName;

    @SerializedName("globalSubjectId")
    private int globalSubjectId;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    public SGOScheduleSubject(String shortName, int globalSubjectId, int id, String name) {
        this.shortName = shortName;
        this.globalSubjectId = globalSubjectId;
        this.id = id;
        this.name = name;
    }

    public SGOScheduleSubject() {
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getGlobalSubjectId() {
        return globalSubjectId;
    }

    public void setGlobalSubjectId(int globalSubjectId) {
        this.globalSubjectId = globalSubjectId;
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
        return "SGOScheduleSubject{" +
                "shortName='" + shortName + '\'' +
                ", globalSubjectId=" + globalSubjectId +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}