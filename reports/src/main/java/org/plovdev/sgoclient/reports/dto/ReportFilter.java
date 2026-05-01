package org.plovdev.sgoclient.reports.dto;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportFilter implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter REPORT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public static @NonNull ReportFilter userFilter(String userId) {
        return new ReportFilter("SID", userId);
    }

    @Contract("_ -> new")
    public static @NonNull ReportFilter markTypeFilter(@NonNull MarkType markType) {
        return new ReportFilter("MerksType", markType.getType());
    }

    @Contract("_ -> new")
    public static @NonNull ReportFilter classFilter(String classId) {
        return new ReportFilter("PCLID", classId);
    }

    @Contract("_ -> new")
    public static @NonNull ReportFilter classIUPFilter(String classId) {
        return new ReportFilter("PCLID_IUP", classId + "_0");
    }

    @Contract("_ -> new")
    public static @NonNull ReportFilter termFilter(String termId) {
        return new ReportFilter("TERMID", termId);
    }

    @Contract("_ -> new")
    public static @NonNull ReportFilter viewTypeFilter(@NonNull ViewType viewType) {
        return new ReportFilter("ViewType", String.valueOf(viewType.getType()));
    }

    @Contract("_ -> new")
    public static @NonNull ReportFilter subjectFilter(int subjectId) {
        return new ReportFilter("SGID", String.valueOf(subjectId));
    }

    public static @NonNull ReportFilter periodFilter(@NonNull LocalDateTime start, @NonNull LocalDateTime end) {
        String periodValue = String.format("%s - %s", start.format(REPORT_DATE_TIME_FORMATTER), end.format(REPORT_DATE_TIME_FORMATTER));
        return new ReportFilter("period", periodValue);
    }

    @SerializedName("filterId")
    private String filterId;

    @SerializedName("filterValue")
    private String filterValue;

    public ReportFilter(String filterId, String filterValue) {
        this.filterId = filterId;
        this.filterValue = filterValue;
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

    public enum MarkType {
        TOTAL_MARKS("T"), EVENT_WORKS("S"), ALL("B");

        private final String type;

        MarkType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public enum ViewType {
        CURRENT_MARKS_BY_TERM(1), YEAR_TOTAL(2);

        private final int type;

        ViewType(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }

    @Override
    public String toString() {
        return "ReportFilter{" +
                "filterId='" + filterId + '\'' +
                ", filterValue='" + filterValue + '\'' +
                '}';
    }
}