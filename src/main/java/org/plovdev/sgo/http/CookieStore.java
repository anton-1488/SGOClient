package org.plovdev.sgo.http;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class CookieStore implements CookieJar {
    private final Map<String, List<Cookie>> cookieStore = new ConcurrentHashMap<>();

    @Override
    public void saveFromResponse(@NonNull HttpUrl url, @NonNull List<Cookie> cookies) {
        cookieStore.put(url.host(), cookies);
    }

    @Override
    public @NonNull List<Cookie> loadForRequest(@NonNull HttpUrl url) {
        return cookieStore.getOrDefault(url.host(), new ArrayList<>());
    }
}