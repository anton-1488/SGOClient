package org.plovdev.sgoclient.core.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Properties;

public final class EnvReader {
    private static final Properties props = new Properties();

    static {
        try (InputStream envStream = EnvReader.class.getResourceAsStream("/.env");
             InputStreamReader reader = new InputStreamReader(Objects.requireNonNull(envStream), StandardCharsets.UTF_8)) {
            props.load(reader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getEnv(String key) {
        return String.valueOf(props.get(key));
    }
}