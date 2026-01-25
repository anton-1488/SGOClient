package org.plovdev.sgo.http.requests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.plovdev.sgo.dto.SGOLogin;
import org.plovdev.sgo.dto.SGOSchool;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;

import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class SGOLoginRequest extends SGORequest<SGOLogin> {
    private final Gson gson = new Gson();

    private int loginType = 1;
    private String acrValues = "{\"back\":\"1\"}";
    private String username;
    private String password;
    private String lt;
    private String ver;
    private SGOSchool SGOSchool;

    public SGOLoginRequest(String username, String pw, String lt, String ver, SGOSchool SGOSchool) {
        this.username = username;
        this.password = pw;
        this.lt = lt;
        this.ver = ver;
        this.SGOSchool = SGOSchool;
    }

    public String getAcrValues() {
        return acrValues;
    }

    public void setAcrValues(String acrValues) {
        this.acrValues = acrValues;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLt() {
        return lt;
    }

    public void setLt(String lt) {
        this.lt = lt;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public SGOSchool getSchool() {
        return SGOSchool;
    }

    public void setSchool(SGOSchool SGOSchool) {
        this.SGOSchool = SGOSchool;
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.POST;
    }

    @Override
    public String endpoint() {
        return SGOHttpPath.LOGIN;
    }

    @Override
    public String params() {
        try {
            // Формируем строку как в form-data
            return String.format(
                    "acr_values=%s&loginType=%d&lt=%s&pw2=%s&scid=%d&un=%s&ver=%s",
                    URLEncoder.encode(acrValues, StandardCharsets.UTF_8),
                    loginType,
                    lt,
                    password,
                    SGOSchool.getId(),
                    URLEncoder.encode(username, StandardCharsets.UTF_8),
                    ver
            );
        } catch (Exception e) {
            throw new RuntimeException("Ошибка кодирования параметров", e);
        }
    }

    @Override
    public String contentType() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    @Override
    public Map<String, String> headers() {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("Referer", SGOHttpPath.BASE_HOST + "authorize/login?back=1");
        headers.put("Origin", SGOHttpPath.BASE_HOST);
        return headers;
    }

    @Override
    public Type responseType() {
        return new TypeToken<SGOLogin>(){}.getType();
    }
}