package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class SGOUserFullInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("firstName")
    private String firstName;

    @SerializedName("lastName")
    private String lastName;

    @SerializedName("middleName")
    private String middleName;

    @SerializedName("loginName")
    private String loginName;

    @SerializedName("birthDate")
    private LocalDate birthDate;

    @SerializedName("roles")
    private List<String> roles;

    @SerializedName("mobilePhone")
    private String mobilePhone;

    @SerializedName("email")
    private String email;

    @SerializedName("existsPhoto")
    private boolean existsPhoto;

    @SerializedName("userSettings")
    private SGOUserSettings userSettings;

    public SGOUserFullInfo(String firstName, String lastName, String middleName, String loginName, LocalDate birthDate, List<String> roles, String mobilePhone, String email, boolean existsPhoto, SGOUserSettings userSettings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.loginName = loginName;
        this.birthDate = birthDate;
        this.roles = roles;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.existsPhoto = existsPhoto;
        this.userSettings = userSettings;
    }

    public SGOUserFullInfo() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getExistsPhoto() {
        return existsPhoto;
    }

    public void setExistsPhoto(boolean existsPhoto) {
        this.existsPhoto = existsPhoto;
    }

    public SGOUserSettings getUserSettings() {
        return userSettings;
    }

    public void setUserSettings(SGOUserSettings userSettings) {
        this.userSettings = userSettings;
    }

    @Override
    public String toString() {
        return "SGOUserFullInfo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", birthDate=" + birthDate +
                ", roles=" + roles +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                ", existsPhoto='" + existsPhoto + '\'' +
                ", userSettings=" + userSettings +
                '}';
    }
}