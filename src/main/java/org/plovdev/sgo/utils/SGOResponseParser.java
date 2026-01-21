package org.plovdev.sgo.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.plovdev.sgo.dto.SGOLogin;

public class SGOResponseParser {
    private static final Gson gson = new Gson();

    /**
     * Парсит JSON ответ от /auth/login
     */
    public static SGOLogin parseLoginResponse(String json) {
        try {
            return gson.fromJson(json, SGOLogin.class);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка парсинга ответа логина", e);
        }
    }

    /**
     * Проверяет, успешен ли ответ
     */
    public static boolean isLoginSuccessful(String json) {
        try {
            JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
            return obj.has("at") && !obj.get("at").isJsonNull() &&
                    obj.has("accessToken") && !obj.get("accessToken").isJsonNull();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Извлекает ID пользователя из ответа
     */
    public static String extractUserId(String json) {
        try {
            JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
            if (obj.has("accountInfo")) {
                JsonObject accountInfo = obj.getAsJsonObject("accountInfo");
                if (accountInfo.has("user")) {
                    JsonObject user = accountInfo.getAsJsonObject("user");
                    if (user.has("id")) {
                        return user.get("id").getAsString();
                    }
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Извлекает имя пользователя из ответа
     */
    public static String extractUserName(String json) {
        try {
            JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
            if (obj.has("accountInfo")) {
                JsonObject accountInfo = obj.getAsJsonObject("accountInfo");
                if (accountInfo.has("user")) {
                    JsonObject user = accountInfo.getAsJsonObject("user");
                    if (user.has("name")) {
                        return user.get("name").getAsString();
                    }
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Извлекает токен доступа
     */
    public static String extractAccessToken(String json) {
        try {
            JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
            if (obj.has("accessToken")) {
                return obj.get("accessToken").getAsString();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Извлекает at-токен
     */
    public static String extractAtToken(String json) {
        try {
            JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
            if (obj.has("at")) {
                return obj.get("at").getAsString();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}