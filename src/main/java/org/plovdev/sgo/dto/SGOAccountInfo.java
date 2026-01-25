package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class SGOAccountInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("activeToken")
    private String activeToken;

    @SerializedName("secureActiveToken")
    private String secureActiveToken;

    @SerializedName("currentOrganization")
    private SGOSchool currentOrganization;

    @SerializedName("user")
    private SGOUser SGOUser;

    @SerializedName("userRoles")
    private List<String> userRoles;

    @SerializedName("organizations")
    private List<SGOSchool> organizations;

    @SerializedName("loginTime")
    private String loginTime;

    @SerializedName("active")
    private Boolean active;

    @SerializedName("canLogin")
    private Boolean canLogin;

    @SerializedName("storeTokens")
    private Boolean storeTokens;

    @SerializedName("accessToken")
    private String accessToken;


    public SGOAccountInfo(String activeToken, String secureActiveToken, SGOSchool currentOrganization, SGOUser SGOUser, List<String> userRoles, List<SGOSchool> organizations, String loginTime, Boolean active, Boolean canLogin, Boolean storeTokens, String accessToken) {
        this.activeToken = activeToken;
        this.secureActiveToken = secureActiveToken;
        this.currentOrganization = currentOrganization;
        this.SGOUser = SGOUser;
        this.userRoles = userRoles;
        this.organizations = organizations;
        this.loginTime = loginTime;
        this.active = active;
        this.canLogin = canLogin;
        this.storeTokens = storeTokens;
        this.accessToken = accessToken;
    }

    public SGOAccountInfo() {
    }

    public String getActiveToken() {
        return activeToken;
    }

    public void setActiveToken(String activeToken) {
        this.activeToken = activeToken;
    }

    public String getSecureActiveToken() {
        return secureActiveToken;
    }

    public void setSecureActiveToken(String secureActiveToken) {
        this.secureActiveToken = secureActiveToken;
    }

    public SGOSchool getCurrentOrganization() {
        return currentOrganization;
    }

    public void setCurrentOrganization(SGOSchool currentOrganization) {
        this.currentOrganization = currentOrganization;
    }

    public SGOUser getUser() {
        return SGOUser;
    }

    public void setUser(SGOUser SGOUser) {
        this.SGOUser = SGOUser;
    }

    public List<String> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<String> userRoles) {
        this.userRoles = userRoles;
    }

    public List<SGOSchool> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<SGOSchool> organizations) {
        this.organizations = organizations;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getCanLogin() {
        return canLogin;
    }

    public void setCanLogin(Boolean canLogin) {
        this.canLogin = canLogin;
    }

    public Boolean getStoreTokens() {
        return storeTokens;
    }

    public void setStoreTokens(Boolean storeTokens) {
        this.storeTokens = storeTokens;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}