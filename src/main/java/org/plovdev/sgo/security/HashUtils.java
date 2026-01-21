package org.plovdev.sgo.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {
    /**
     * Вычисляет MD5 хеш строки
     * Всегда возвращает 32 шестнадцатеричных символа (lowercase)
     */
    public static String md5(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(text.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not available", e);
        }
    }

    public static boolean verifyMd5(String text, String md5Hash) {
        String computedHash = md5(text);
        return computedHash.equals(md5Hash);
    }

    public static boolean compareMd5(String md5Hash1, String md5Hash2) {
        return md5Hash1 != null && md5Hash1.equals(md5Hash2);
    }

    public static String createPassword(String salt, String passw) {
        return md5(salt + md5(passw));
    }
}