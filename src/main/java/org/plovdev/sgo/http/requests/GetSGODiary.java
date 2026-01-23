package org.plovdev.sgo.http.requests;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgo.dto.SGODiary;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class GetSGODiary extends SGORequest<SGODiary> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private LocalDate weekStart;
    private LocalDate weekEnd;
    private int yearId;

    public GetSGODiary(LocalDate weekStart, LocalDate weekEnd, int yearId) {
        this.weekStart = weekStart;
        this.weekEnd = weekEnd;
        this.yearId = yearId;
    }

    public GetSGODiary() {
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
        return SGOHttpPath.DIARY + String.format("?weekEnd=%s&weekStart=%s&yearId=%s", weekEnd.format(formatter), weekStart.format(formatter), yearId);
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