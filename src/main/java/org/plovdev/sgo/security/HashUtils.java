package org.plovdev.sgo.security;

import org.jspecify.annotations.NonNull;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public final class HashUtils {
    private static final HexFormat HEX = HexFormat.of();

    private HashUtils() {
        throw new UnsupportedOperationException();
    }

    /**
     * Вычисляет MD5 хеш строки
     * Всегда возвращает 32 шестнадцатеричных символа (lowercase)
     */
    public static @NonNull String md5(String plain) {
        return processAlgorithm("MD5", plain);
    }

    public static @NonNull String processAlgorithm(String algorithm, @NonNull String plain) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            digest.update(plain.getBytes(StandardCharsets.UTF_8));
            return HEX.formatHex(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(algorithm + " algorithm not found", e);
        }
    }

    @NonNull
    public static String createPassword(String salt, String passw) {
        return md5(salt + md5(passw));
    }
}