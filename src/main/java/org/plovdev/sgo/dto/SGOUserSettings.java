package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class SGOUserSettings implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("showMobilePhone")
    private boolean showMobilePhone;

    @SerializedName("language")
    private String language;

    @SerializedName("passwordExpired")
    private int passwordExpired;

    @SerializedName("recoveryAnswer")
    private String recoveryAnswer;

    @SerializedName("recoveryQuestion")
    private String recoveryQuestion;

    @SerializedName("theme")
    private int theme;

    @SerializedName("userId")
    private int userId;

    @SerializedName("showNetSchoolApp")
    private boolean showNetSchoolApp;

    @SerializedName("showSferumBanner")
    private boolean showSferumBanner;

    public SGOUserSettings(boolean showMobilePhone, String language, int passwordExpired, String recoveryAnswer, String recoveryQuestion, int theme, int userId, boolean showNetSchoolApp, boolean showSferumBanner) {
        this.showMobilePhone = showMobilePhone;
        this.language = language;
        this.passwordExpired = passwordExpired;
        this.recoveryAnswer = recoveryAnswer;
        this.recoveryQuestion = recoveryQuestion;
        this.theme = theme;
        this.userId = userId;
        this.showNetSchoolApp = showNetSchoolApp;
        this.showSferumBanner = showSferumBanner;
    }

    public SGOUserSettings() {
    }

    public boolean isShowMobilePhone() {
        return showMobilePhone;
    }

    public void setShowMobilePhone(boolean showMobilePhone) {
        this.showMobilePhone = showMobilePhone;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(int passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public String getRecoveryAnswer() {
        return recoveryAnswer;
    }

    public void setRecoveryAnswer(String recoveryAnswer) {
        this.recoveryAnswer = recoveryAnswer;
    }

    public String getRecoveryQuestion() {
        return recoveryQuestion;
    }

    public void setRecoveryQuestion(String recoveryQuestion) {
        this.recoveryQuestion = recoveryQuestion;
    }

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isShowNetSchoolApp() {
        return showNetSchoolApp;
    }

    public void setShowNetSchoolApp(boolean showNetSchoolApp) {
        this.showNetSchoolApp = showNetSchoolApp;
    }

    public boolean isShowSferumBanner() {
        return showSferumBanner;
    }

    public void setShowSferumBanner(boolean showSferumBanner) {
        this.showSferumBanner = showSferumBanner;
    }

    @Override
    public String toString() {
        return "SGOUserSettings{" +
                "showMobilePhone=" + showMobilePhone +
                ", language='" + language + '\'' +
                ", passwordExpired=" + passwordExpired +
                ", recoveryAnswer='" + recoveryAnswer + '\'' +
                ", recoveryQuestion='" + recoveryQuestion + '\'' +
                ", theme=" + theme +
                ", userId=" + userId +
                ", showNetSchoolApp=" + showNetSchoolApp +
                ", showSferumBanner=" + showSferumBanner +
                '}';
    }
}