package org.plovdev.sgoclient.core.reports;

public enum SGOReportType {
    FINAL_GRADES("studenttotalmarks"),
    AVERAGE_MARK("studentaveragemark"),
    AVERAGE_MARK_DYNAMIC("studentaveragemarkdyn"),
    STUDENT_GRADES("studentgrades"),
    STUDENT_TOTAL("studenttotal"),
    STUDENT_TOTAL_QUALITY("studentattendancegrades"),
    JOURNAL_ACCESS("journalaccess"),
    PARENT_INFO("parentinfoletter"),
    DOP_EDUCATION("dopeducstudent");

    private final String type;

    SGOReportType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}