package org.plovdev.sgo;

import okhttp3.*;
import org.jspecify.annotations.NonNull;
import org.plovdev.sgo.dto.SGOContext;
import org.plovdev.sgo.dto.SGOLogin;
import org.plovdev.sgo.dto.SGOLoginData;
import org.plovdev.sgo.dto.SGOSchool;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;
import org.plovdev.sgo.http.requests.SGORequest;
import org.plovdev.sgo.http.requests.commons.GetSGOContext;
import org.plovdev.sgo.http.requests.login.GetSGOLoginData;
import org.plovdev.sgo.http.requests.login.SGOLoginRequest;
import org.plovdev.sgo.http.requests.login.SGOLogoutRequest;
import org.plovdev.sgo.reports.dto.SGOReport;
import org.plovdev.sgo.reports.requests.LoadSGOReportRequest;
import org.plovdev.sgo.security.AuthKeys;
import org.plovdev.sgo.security.HashUtils;
import org.plovdev.sgo.utils.Globals;
import org.plovdev.sgo.utils.SGOSessionRefresher;
import org.plovdev.sgo.ws.SGOWebSocketClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Proxy;
import java.util.Map;
import java.util.Objects;

import static org.plovdev.sgo.utils.Globals.GSON;

public class SGOClient implements AutoCloseable {
    private static final Logger log = LoggerFactory.getLogger(SGOClient.class);
    private OkHttpClient HTTP_CLIENT = Globals.HTTP_CLIENT;
    private final SGOSessionRefresher refresher = new SGOSessionRefresher(this);

    private final AuthKeys authKeys;
    private volatile SGOSession currentSession;

    public SGOClient(AuthKeys keys) {
        authKeys = keys;
    }

    public AuthKeys getAuthKeys() {
        return authKeys;
    }

    public SGOSession getCurrentSession() {
        return currentSession;
    }

    public SGOSession createSession(SGOSchool school) {
        return createSession(school, ClientRole.STUDENT);
    }

    public synchronized SGOSession createSession(SGOSchool school, ClientRole role) {
        if (currentSession != null) {
            return currentSession;
        }
        if (authKeys == null) {
            throw new IllegalArgumentException("Auth keys can't be null!");
        }
        SGOLoginData loginData = execute(new GetSGOLoginData());
        SGOLoginRequest sgoLoginRequest = new SGOLoginRequest(role.getRole(), authKeys.username(), HashUtils.createPassword(loginData.getSalt(), authKeys.password()), loginData.getLt(), loginData.getVer(), school);
        SGOLogin sgoLogin = execute(sgoLoginRequest);

        currentSession = new SGOSession(loginData, sgoLogin, null);
        SGOContext sgoContext = execute(new GetSGOContext());
        currentSession.setSgoContext(sgoContext);
        refresher.startRefreshLoop(authKeys, school, role);
        Globals.setCurrentSession(currentSession);

        return currentSession;
    }

    public <T> T execute(SGORequest<?> request) {
        try (Response response = HTTP_CLIENT.newCall(buildRequest(request)).execute()) {
            if (response.isSuccessful()) {
                return GSON.fromJson(response.body().string(), request.responseType().getType());
            } else {
                String errorBody = response.body().string();
                throw new RuntimeException("HTTP " + response.code() + ": " + errorBody);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SGOReport loadReport(LoadSGOReportRequest request) {
        try (Response response = HTTP_CLIENT.newCall(buildRequest(request)).execute()) {
            if (response.isSuccessful()) {
                byte[] data = response.body().bytes();
                return new SGOReport(data);
            } else {
                throw new RuntimeException("HTTP " + response.code() + ": " + response.body().string());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private @NonNull Request buildRequest(@NonNull SGORequest<?> request) {
        Request.Builder builder = new Request.Builder();
        builder.url(SGOHttpPath.BASE_HOST + request.endpoint());

        Map<String, String> defHeaders = SGORequest.getDefaultHeaders();
        defHeaders.put("Content-Type", request.contentType());
        addHeaders(builder, defHeaders);
        addHeaders(builder, request.headers());

        if (currentSession != null) {
            SGOLogin sgoLogin = currentSession.getSgoLogin();
            if (sgoLogin != null) {
                builder.header("At", sgoLogin.getAt());
            }
        }

        if (request.method() == HttpMethod.GET) {
            String params = request.params();
            if (params != null && !params.trim().isEmpty()) {
                builder.url(SGOHttpPath.BASE_HOST + request.endpoint() + "?" + params);
            }
            return builder.get().build();
        } else if (request.method() == HttpMethod.POST) {
            String body = request.params();
            if (body == null || body.trim().isEmpty()) {
                return builder.post(RequestBody.EMPTY).build();
            } else {
                return builder.post(RequestBody.create(body, MediaType.parse(request.contentType()))).build();
            }
        } else {
            throw new UnsupportedOperationException("Unsupported method: " + request.method());
        }
    }

    private void addHeaders(Request.Builder builder, @NonNull Map<String, String> headers) {
        for (String header : headers.keySet()) {
            builder.header(header, headers.get(header));
        }
    }

    public synchronized void setProxy(Proxy proxy, Authenticator authenticator) {
        OkHttpClient.Builder builder = HTTP_CLIENT.newBuilder();
        builder.proxy(Objects.requireNonNullElse(proxy, Proxy.NO_PROXY));
        if (authenticator != null) {
            builder.authenticator(authenticator);
        }
        HTTP_CLIENT = builder.build();
    }

    public SGOWebSocketClient createSGOWebSocketClient() {
        return new SGOWebSocketClient(HTTP_CLIENT);
    }

    @Override
    public void close() {
        refresher.stopRefreshLoop();
        execute(new SGOLogoutRequest(currentSession.getSgoLogin().getAt(), currentSession.getLoginData().getVer()));
        currentSession = null;
        Globals.setCurrentSession(null);

        log.info("Session logouted");
    }
}