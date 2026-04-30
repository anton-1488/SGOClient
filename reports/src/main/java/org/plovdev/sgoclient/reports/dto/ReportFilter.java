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
    private static final DateTimeFormatter READABLE_REPORT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static @NonNull ReportFilter userFilter(String userId, String userName) {
        return new ReportFilter("SID", userId, userName);
    }

    @Contract("_ -> new")
    public static @NonNull ReportFilter markTypeFilter(@NonNull MarkType markType) {
        return new ReportFilter("MerksType", markType.getType(), markType.getText());
    }

    public static @NonNull ReportFilter classFilter(String classId, String className) {
        return new ReportFilter("PCLID", classId, className);
    }

    public static @NonNull ReportFilter classIUPFilter(String classId, String className) {
        return new ReportFilter("PCLID_IUP", classId + "_0", className);
    }

    public static @NonNull ReportFilter termFilter(String termId, String termName) {
        return new ReportFilter("TERMID", termId, termName);
    }

    public static @NonNull ReportFilter viewTypeFilter(ViewType viewType) {
        return new ReportFilter("ViewType", String.valueOf(viewType.getType()), viewType.getText());
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NonNull ReportFilter subjectFilter(int subjectId, String subjectName) {
        return new ReportFilter("SGID", String.valueOf(subjectId), subjectName);
    }

    public static @NonNull ReportFilter periodFilter(@NonNull LocalDateTime start, @NonNull LocalDateTime end) {
        String periodValue = String.format("%s - %s", start.format(REPORT_DATE_TIME_FORMATTER), end.format(REPORT_DATE_TIME_FORMATTER));
        String periodText = String.format("%s - %s", start.format(READABLE_REPORT_DATE_TIME_FORMATTER), end.format(READABLE_REPORT_DATE_TIME_FORMATTER));
        return new ReportFilter("period", periodValue, periodText);
    }

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

    public enum MarkType {
        TOTAL_MARKS("T", "Итоговые отметки"), EVENT_WORKS("S", "Тематические работы"), ALL("B", "Итоговые отметки и тематические работы");

        private final String type;
        private final String text;

        MarkType(String type, String text) {
            this.type = type;
            this.text = text;
        }

        public String getType() {
            return type;
        }

        public String getText() {
            return text;
        }
    }

    public enum ViewType {
        CURRENT_MARKS_BY_TERM(1, "Текущие оценки за период"), YEAR_TOTAL(2, "Итоги учебного периода");

        private final int type;
        private final String text;

        ViewType(int type, String text) {
            this.type = type;
            this.text = text;
        }

        public int getType() {
            return type;
        }

        public String getText() {
            return text;
        }
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