package org.plovdev.sgo.http.requests.user;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgo.dto.SGODiary;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;
import org.plovdev.sgo.http.requests.SGORequest;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/*
schoolId: 130
studentId: 931474
vers: 1768844293853
weekEnd: 2026-02-01
weekStart: 2026-01-26
withLaAssigns: true
yearId: 91715
 */
public class GetSGODiary extends SGORequest<SGODiary> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private LocalDate weekStart;
    private LocalDate weekEnd;
    private int userId = 0;
    private int yearId;


    public GetSGODiary(LocalDate weekStart, LocalDate weekEnd, int yearId) {
        this.weekStart = weekStart;
        this.weekEnd = weekEnd;
        this.yearId = yearId;
    }

    public GetSGODiary(LocalDate weekStart, LocalDate weekEnd, int userId, int yearId) {
        this.weekStart = weekStart;
        this.weekEnd = weekEnd;
        this.userId = userId;
        this.yearId = yearId;
    }

    public GetSGODiary() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getWeekStart() {
        return weekStart;
    }

    public void setWeekStart(LocalDate weekStart) {
        this.weekStart = weekStart;
    }

    public LocalDate getWeekEnd() {
        return weekEnd;
    }

    public void setWeekEnd(LocalDate weekEnd) {
        this.weekEnd = weekEnd;
    }

    public int getYearId() {
        return yearId;
    }

    public void setYearId(int yearId) {
        this.yearId = yearId;
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.GET;
    }

    @Override
    public String endpoint() {
        String user = "";
        if (userId != 0) {
            user = "&studentId=" + userId;
        }
        return SGOHttpPath.DIARY + String.format("?weekEnd=%s&weekStart=%s&yearId=%s", weekEnd.format(formatter), weekStart.format(formatter), yearId) + user;
    }

    @Override
    public String params() {
        return "";
    }

    @Override
    public String contentType() {
        return "application/json; charset=utf-8";
    }

    @Override
    public Map<String, String> headers() {
        return Map.of();
    }

    @Override
    public Type responseType() {
        return new TypeToken<SGODiary>(){}.getType();
    }
}