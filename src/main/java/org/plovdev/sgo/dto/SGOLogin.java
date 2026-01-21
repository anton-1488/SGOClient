package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

public class SGOLogin implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("at")
    private String at;

    @SerializedName("code")
    private String code;

    @SerializedName("timeOut")
    private Integer timeOut;

    @SerializedName("accessToken")
    private String accessToken;

    @SerializedName("refreshToken")
    private String refreshToken;

    @SerializedName("accountInfo")
    private AccountInfo accountInfo;

    @SerializedName("tokenType")
    private String tokenType;

    @SerializedName("entryPoint")
    private String entryPoint;

    @SerializedName("requestData")
    private Map<String, Object> requestData;

    @SerializedName("errorMessage")
    private String errorMessage;

    public SGOLogin(String at, String code, Integer timeOut, String accessToken, String refreshToken, AccountInfo accountInfo, String tokenType, String entryPoint, Map<String, Object> requestData, String errorMessage) {
        this.at = at;
        this.code = code;
        this.timeOut = timeOut;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.accountInfo = accountInfo;
        this.tokenType = tokenType;
        this.entryPoint = entryPoint;
        this.requestData = requestData;
        this.errorMessage = errorMessage;
    }

    public SGOLogin() {
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getEntryPoint() {
        return entryPoint;
    }

    public void setEntryPoint(String entryPoint) {
        this.entryPoint = entryPoint;
    }

    public Map<String, Object> getRequestData() {
        return requestData;
    }

    public void setRequestData(Map<String, Object> requestData) {
        this.requestData = requestData;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    // Проверка успешности
    public boolean isSuccess() {
        return at != null && !at.isEmpty() &&
                accessToken != null && !accessToken.isEmpty();
    }

    @Override
    public String toString() {
        return String.format(
                "SGOLoginResponse{at='%s', user='%s', org='%s', token=%s}",
                at != null ? at.substring(0, Math.min(10, at.length())) + "..." : "null",
                accountInfo != null && accountInfo.getUser() != null ?
                        accountInfo.getUser().getName() : "null",
                accountInfo != null && accountInfo.getCurrentOrganization() != null ? accountInfo.getCurrentOrganization().getSchoolName() : "null",
                accessToken != null ? "present" : "null"
        );
    }
}