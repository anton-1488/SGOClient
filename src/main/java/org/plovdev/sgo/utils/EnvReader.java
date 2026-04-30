package org.plovdev.sgo.utils;

import java.io.InputStream;
import java.util.Properties;

public final class EnvReader {
    private static final Properties props = new Properties();

    static {
        try (InputStream envStream = EnvReader.class.getResourceAsStream("/.env")) {
            props.load(envStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getEnv(String key) {
        return String.valueOf(props.get(key));
    }
}