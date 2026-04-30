package org.plovdev.sgoclient.core.http.requests;

import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;
import org.plovdev.sgoclient.core.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

public abstract class SGORequest<T> {
    private static final Map<String, String> DEFAULT_HEADERS = new HashMap<>();

    static {
        DEFAULT_HEADERS.put("Accept", "application/json, text/plain, */*");
        DEFAULT_HEADERS.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36");
        DEFAULT_HEADERS.put("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7");
        DEFAULT_HEADERS.put("Accept-Encoding", "gzip, deflate, br, zstd");
        DEFAULT_HEADERS.put("Sec-Fetch-Dest", "empty");
        DEFAULT_HEADERS.put("Sec-Fetch-Mode", "cors");
        DEFAULT_HEADERS.put("Sec-Fetch-Site", "same-origin");
        DEFAULT_HEADERS.put("Sec-Ch-Ua", "\"Chromium\";v=\"128\", \"Not;A=Brand\";v=\"24\", \"Google Chrome\";v=\"128\"");
        DEFAULT_HEADERS.put("Sec-Ch-Ua-Mobile", "?0");
        DEFAULT_HEADERS.put("Sec-Ch-Ua-Platform", "\"macOS\"");
        DEFAULT_HEADERS.put("ver-front", "5.45.78628");
    }

    @Contract(pure = true)
    public static @NonNull Map<String, String> getDefaultHeaders() {
        return new HashMap<>(DEFAULT_HEADERS);
    }

    public SGORequest() {
    }

    public abstract HttpMethod method();

    public abstract String endpoint();

    public abstract String params();

    public abstract String contentType();

    public abstract Map<String, String> headers();

    public abstract TypeToken<T> responseType();
}