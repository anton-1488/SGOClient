package org.plovdev.sgoclient.core.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.Strictness;
import okhttp3.OkHttpClient;
import org.plovdev.sgoclient.core.http.CookieStore;
import org.plovdev.sgoclient.core.utils.json.DateAdapter;
import org.plovdev.sgoclient.core.utils.json.DateTimeAdapter;
import org.plovdev.sgoclient.core.utils.json.TimeAdapter;

import java.time.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class Globals {
    public static final ExecutorService VIRTUAL_EXECUTOR = Executors.newVirtualThreadPerTaskExecutor();
    public static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new DateAdapter())
            .registerTypeAdapter(LocalTime.class, new TimeAdapter())
            .registerTypeAdapter(LocalDateTime.class, new DateTimeAdapter())
            .setStrictness(Strictness.LENIENT)
            .create();
    public static final OkHttpClient HTTP_CLIENT = new OkHttpClient.Builder()
            .connectTimeout(Duration.ofSeconds(60))
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .followRedirects(true)
            .cookieJar(new CookieStore())
            .build();

    public static int getCurrentTimeZoneOffset() {
        return OffsetDateTime.now().getOffset().getTotalSeconds() / 3600;
    }

    private static final List<Runnable> HOOKS = new CopyOnWriteArrayList<>();

    private Globals() {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(VIRTUAL_EXECUTOR::close));
        runtime.addShutdownHook(new Thread(() -> HOOKS.forEach(Runnable::run)));
    }

    public static void addShootdownHook(Runnable r) {
        HOOKS.add(r);
    }

    public static void removeShootdownHook(Runnable r) {
        HOOKS.remove(r);
    }
}