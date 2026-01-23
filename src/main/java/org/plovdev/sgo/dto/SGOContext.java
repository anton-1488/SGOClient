package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class SGOContext implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("userId")
    private int userId;

    @SerializedName("functType")
    private String functType;

    @SerializedName("schoolYearId")
    private int yearId;

    @SerializedName("globalYearId")
    private int globalYearId;

    @SerializedName("userLanguage")
    private String userLanguage;

    @SerializedName("organizationName")
    private String orgName;

    @SerializedName("isEmForSchool")
    private boolean isEmForSchool;


    public SGOContext(int userId, String functType, int yearId, int globalYearId, String userLanguage, String orgName, boolean isEmForSchool) {
        this.userId = userId;
        this.functType = functType;
        this.yearId = yearId;
        this.globalYearId = globalYearId;
        this.userLanguage = userLanguage;
        this.orgName = orgName;
        this.isEmForSchool = isEmForSchool;
    }

    public SGOContext() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFunctType() {
        return functType;
    }

    public void setFunctType(String functType) {
        this.functType = functType;
    }

    public int getYearId() {
        return yearId;
    }

    public void setYearId(int yearId) {
        this.yearId = yearId;
    }

    public int getGlobalYearId() {
        return globalYearId;
    }

    public void setGlobalYearId(int globalYearId) {
        this.globalYearId = globalYearId;
    }

    public String getUserLanguage() {
        return userLanguage;
    }

    public void setUserLanguage(String userLanguage) {
        this.userLanguage = userLanguage;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public boolean isEmForSchool() {
        return isEmForSchool;
    }

    public void setEmForSchool(boolean emForSchool) {
        isEmForSchool = emForSchool;
    }

    @Override
    public String toString() {
        return "SGOContext{" +
                "userId=" + userId +
                ", functType='" + functType + '\'' +
                ", yearId=" + yearId +
                ", globalYearId=" + globalYearId +
                ", userLanguage='" + userLanguage + '\'' +
                ", orgName='" + orgName + '\'' +
                ", isEmForSchool=" + isEmForSchool +
                '}';
    }
}