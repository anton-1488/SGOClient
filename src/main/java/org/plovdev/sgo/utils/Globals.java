package org.plovdev.sgo.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.plovdev.sgo.utils.json.DateAdapter;
import org.plovdev.sgo.utils.json.TimeAdapter;

import java.time.LocalDate;
import java.time.LocalTime;

public class Globals {
    public static final Gson GSON;

    static {
        GSON = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new DateAdapter())
                .registerTypeAdapter(LocalTime.class, new TimeAdapter())
                .setLenient()
                .create();

    }
}