package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class SGOLoginData implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("lt")
    private String lt;

    @SerializedName("ver")
    private String ver;

    @SerializedName("salt")
    private String salt;

    public SGOLoginData() {
    }

    public SGOLoginData(String lt, String ver, String salt) {
        this.lt = lt;
        this.ver = ver;
        this.salt = salt;
    }

    public String getLt() {
        return lt;
    }

    public void setLt(String lt) {
        this.lt = lt;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "SGOLoginData{" +
                "lt='" + lt + '\'' +
                ", ver='" + ver + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}