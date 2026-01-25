package org.plovdev.sgo.reports.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class ReportFilter implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("filterId")
    private String filterId;

    @SerializedName("filterValue")
    private String filterValue;

    @SerializedName("filterText")
    private String filterText;

    public ReportFilter(String filterId, String filterValue, String filterText) {
        this.filterId = filterId;
        this.filterValue = filterValue;
        this.filterText = filterText;
    }

    public ReportFilter() {
    }

    public String getFilterId() {
        return filterId;
    }

    public void setFilterId(String filterId) {
        this.filterId = filterId;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    public String getFilterText() {
        return filterText;
    }

    public void setFilterText(String filterText) {
        this.filterText = filterText;
    }

    @Override
    public String toString() {
        return "ReportFilter{" +
                "filterId='" + filterId + '\'' +
                ", filterValue='" + filterValue + '\'' +
                ", filterText='" + filterText + '\'' +
                '}';
    }
}