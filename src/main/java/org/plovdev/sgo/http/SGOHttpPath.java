package org.plovdev.sgo.http;

public interface SGOHttpPath {
    String BASE_HOST = "http://sgo.volganet.ru/";
    String LOGIN_DATA = "webapi/auth/getdata";
    String LOGIN = "webapi/auth/login";
    String STATE = "webapi/context/state";
    String EXPIRED = "webapi/context/expired";
    String DIARY = "webapi/student/diary";
    String CONTEXT = "webapi/context";
    String USER_SETTINGS = "webapi/usersettings";
    String SCHEDULE = "webapi/subjectgroups";
    String REPORT_QUEUE = "webapi/reports/studenttotal/queue";
    String REPORT_TASK = "signalr/queueHub";
    String NEGOTINATE = "signalr/queueHub/negotiate";
    String EARLY_ACCESS = "webapi/earlyaccess";
    String SEARCH_SCHOOL = "webapi/schools/search";
    String ACCOUNT_FULL_INFO = "webapi/mysettings";
    String ANNOUNCEMENTS = "webapi/announcements";
}