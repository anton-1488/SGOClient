package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class SGOSchedule implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("class")
    private SGOClass sgoClass;

    @SerializedName("shortName")
    private String shortName;

    @SerializedName("terms")
    private List<Integer> terms;

    @SerializedName("teachers")
    private List<SGOUser> teachers;

    @SerializedName("subject")
    private SGOScheduleSubject scheduleSubject;

    @SerializedName("ip")
    private boolean iup;

    @SerializedName("extraCurricular")
    private boolean extraCurricular;

    @SerializedName("gradingSys")
    private String gradingSys;

    @SerializedName("useExemption")
    private boolean useExemption;

    @SerializedName("fullName")
    private String fullName;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    public SGOSchedule(SGOClass sgoClass, String shortName, List<Integer> terms, List<SGOUser> teachers, SGOScheduleSubject scheduleSubject, boolean iup, boolean extraCurricular, String gradingSys, boolean useExemption, String fullName, int id, String name) {
        this.sgoClass = sgoClass;
        this.shortName = shortName;
        this.terms = terms;
        this.teachers = teachers;
        this.scheduleSubject = scheduleSubject;
        this.iup = iup;
        this.extraCurricular = extraCurricular;
        this.gradingSys = gradingSys;
        this.useExemption = useExemption;
        this.fullName = fullName;
        this.id = id;
        this.name = name;
    }

    public SGOSchedule() {
    }

    public SGOClass getSgoClass() {
        return sgoClass;
    }

    public void setSgoClass(SGOClass sgoClass) {
        this.sgoClass = sgoClass;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<Integer> getTerms() {
        return terms;
    }

    public void setTerms(List<Integer> terms) {
        this.terms = terms;
    }

    public List<SGOUser> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<SGOUser> teachers) {
        this.teachers = teachers;
    }

    public SGOScheduleSubject getScheduleSubject() {
        return scheduleSubject;
    }

    public void setScheduleSubject(SGOScheduleSubject scheduleSubject) {
        this.scheduleSubject = scheduleSubject;
    }

    public boolean isIup() {
        return iup;
    }

    public void setIup(boolean iup) {
        this.iup = iup;
    }

    public boolean isExtraCurricular() {
        return extraCurricular;
    }

    public void setExtraCurricular(boolean extraCurricular) {
        this.extraCurricular = extraCurricular;
    }

    public String getGradingSys() {
        return gradingSys;
    }

    public void setGradingSys(String gradingSys) {
        this.gradingSys = gradingSys;
    }

    public boolean isUseExemption() {
        return useExemption;
    }

    public void setUseExemption(boolean useExemption) {
        this.useExemption = useExemption;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
        return "SGOSchedule{" +
                "sgoClass=" + sgoClass +
                ", shortName='" + shortName + '\'' +
                ", terms=" + terms +
                ", teachers=" + teachers +
                ", scheduleSubject=" + scheduleSubject +
                ", iup=" + iup +
                ", extraCurricular=" + extraCurricular +
                ", gradingSys='" + gradingSys + '\'' +
                ", useExemption=" + useExemption +
                ", fullName='" + fullName + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}