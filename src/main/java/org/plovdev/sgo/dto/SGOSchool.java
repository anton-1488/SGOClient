package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class SGOSchool implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("provinceId")
    private int provinceId;

    @SerializedName("cityId")
    private int cityId;

    @SerializedName("inn")
    private String inn;

    @SerializedName("ogrn")
    private String ogrn;

    @SerializedName("address")
    private String address;

    @SerializedName("shortName")
    private String name;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String fullName;

    public SGOSchool(int provinceId, int cityId, String inn, String ogrn, String address, String name, int id, String fullName) {
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.inn = inn;
        this.ogrn = ogrn;
        this.address = address;
        this.name = name;
        this.id = id;
        this.fullName = fullName;
    }

    public SGOSchool() {
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String orgn) {
        this.ogrn = orgn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "SGOSchool{" +
                "provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", inn='" + inn + '\'' +
                ", orgn='" + ogrn + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", fullName=" + fullName +
                '}';
    }
}