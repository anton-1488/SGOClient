package org.plovdev.sgo.reports;

public enum SGOReportType {
    WEEKLY_PARENT("report-v1"), STUDENT_ATTENDANCE("report-v2"), FINAL_GRADES("report-v3");

    private final String name;

    SGOReportType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}