package org.plovdev.sgo;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.plovdev.sgo.dto.SGOLogin;
import org.plovdev.sgo.dto.SGOLoginData;
import org.plovdev.sgo.dto.School;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;
import org.plovdev.sgo.http.requests.GetSGOLoginData;
import org.plovdev.sgo.http.requests.SGOLoginRequest;
import org.plovdev.sgo.http.requests.SGORequest;
import org.plovdev.sgo.security.AuthKeys;
import org.plovdev.sgo.security.HashUtils;
import org.plovdev.sgo.utils.SGOResponseParser;
import org.plovdev.sgo.utils.SGOSessionRefresher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SGOClient implements AutoCloseable {
    private static final Logger log = LoggerFactory.getLogger(SGOClient.class);
    private final CookieManager cookieManager = new CookieManager();
    private final SGOSessionRefresher refresher = new SGOSessionRefresher();
    private final Gson gson = new Gson();

    private AuthKeys authKeys;
    private SGOSession currentSession;

    private final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .followRedirects(HttpClient.Redirect.NORMAL)
            .version(HttpClient.Version.HTTP_2)
            .cookieHandler(cookieManager)
            .build();
    private final ExecutorService asyncExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

    public SGOClient(AuthKeys keys) {
        authKeys = keys;
    }

    public SGOClient() {

    }

    public AuthKeys getAuthKeys() {
        return authKeys;
    }

    public void setAuthKeys(AuthKeys authKeys) {
        this.authKeys = authKeys;
    }

    public SGOSession createSession(School school, ClientRole role) throws Exception {
        if (authKeys == null) {
            throw new IllegalArgumentException("Auth keys can't be null!");
        }
        if (currentSession != null) {
            return currentSession;
        }

        makeInitialRequest(school);
        String cookieHeader = getCookieHeader();
        SGOLoginData loginData = getLoginData();
        SGOSession sgoSession = new SGOSession(cookieHeader, loginData, null);

        SGOLoginRequest sgoLoginRequest = new SGOLoginRequest(authKeys.username(), HashUtils.createPassword(loginData.getSalt(), authKeys.password()), loginData.getLt(), loginData.getVer(), school);
        if (role == ClientRole.TEACHER) {
            sgoLoginRequest.setLoginType(2);
        } else {
            sgoLoginRequest.setLoginType(1);
        }

        HttpRequest loginRequest = buildRequest(sgoLoginRequest);

        HttpResponse<String> loginResponse = httpClient.send(loginRequest, HttpResponse.BodyHandlers.ofString());
        if (loginResponse.statusCode() != 200) {
            throw new RuntimeException("Ошибка авторизации. HTTP: " + loginResponse.statusCode() + ", тело: " + loginResponse.body());
        }

        SGOLogin loginResult = SGOResponseParser.parseLoginResponse(loginResponse.body());
        sgoSession.setSgoLogin(loginResult);
        currentSession = sgoSession;

        refresher.setSession(sgoSession);
        refresher.startRefreshLoop();

        return sgoSession;
    }

    public <T> T execute(SGORequest<?> request) {
        try {
            HttpRequest httpRequest = buildRequest(request);
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                log.warn("Status code is not 200: {}, URL: {}", response.statusCode(), httpRequest.uri());
                throw new RuntimeException("HTTP error: " + response.statusCode() + ", body: " + response.body());
            }
            String body = response.body();
            log.debug("Response body: {}", body);

            return gson.fromJson(body, request.responseType());
        } catch (Exception e) {
            log.error("Error sending request: {}", e.getMessage(), e);
            throw new RuntimeException("Request failed: " + e.getMessage(), e);
        }
    }

    private HttpRequest buildRequest(SGORequest<?> request) {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(SGOHttpPath.BASE_HTTP_URL + request.endpoint()))
                .header("Content-Type", request.contentType())
                .header("Accept", "application/json, text/plain, */*")
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36")
                .header("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("Accept-Encoding", "gzip, deflate, br, zstd")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "same-origin")
                .header("Sec-Ch-Ua", "\"Chromium\";v=\"128\", \"Not;A=Brand\";v=\"24\", \"Google Chrome\";v=\"128\"")
                .header("Sec-Ch-Ua-Mobile", "?0")
                .header("Sec-Ch-Ua-Platform", "\"macOS\"")
                .header("ver-front", "5.45.78628")
                .timeout(Duration.ofSeconds(10));

        if (request.headers() != null && !request.headers().isEmpty()) {
            for (Map.Entry<String, String> entry : request.headers().entrySet()) {
                builder.header(entry.getKey(), entry.getValue());
            }
        }

        if (currentSession != null) {
            String cookie = currentSession.getCookie();
            if (cookie != null && !cookie.isEmpty()) {
                builder.header("Cookie", currentSession.getCookie());
            }
            SGOLogin sgoLogin = currentSession.getSgoLogin();
            if (sgoLogin != null) {
                builder.header("At", sgoLogin.getAt());
            }
        }

        if (request.method() == HttpMethod.GET) {
            return builder.GET().build();
        } else if (request.method() == HttpMethod.POST) {
            String body = request.params();
            // Для POST запросов
            if (body == null || body.trim().isEmpty()) {
                return builder.POST(HttpRequest.BodyPublishers.noBody()).build();
            } else {
                return builder.POST(HttpRequest.BodyPublishers.ofString(body)).build();
            }
        } else {
            throw new UnsupportedOperationException("Unsupported method: " + request.method());
        }
    }

    private SGOLoginData getLoginData() throws Exception {
        GetSGOLoginData getSGOLoginData = new GetSGOLoginData();
        HttpRequest loginData = buildRequest(getSGOLoginData);
        HttpResponse<String> loginDataResponse = httpClient.send(loginData, HttpResponse.BodyHandlers.ofString());

        if (loginDataResponse.statusCode() != 200) {
            throw new IllegalArgumentException("Status code is not 200");
        }

        String loginDataBody = loginDataResponse.body();
        JsonElement loginDataElement = JsonParser.parseString(loginDataBody);
        log.debug("LoginData response: {}", loginDataElement);

        return gson.fromJson(loginDataBody, getSGOLoginData.responseType());
    }


    private String getCookieHeader() {
        try {
            CookieStore cookieStore = cookieManager.getCookieStore();
            List<HttpCookie> cookies = cookieStore.getCookies();

            if (cookies.isEmpty()) {
                return "";
            }

            StringBuilder sb = new StringBuilder();
            for (HttpCookie cookie : cookies) {
                if (!sb.isEmpty()) {
                    sb.append("; ");
                }
                sb.append(cookie.getName()).append("=").append(cookie.getValue());
            }

            return sb.toString();
        } catch (Exception e) {
            System.err.println("Ошибка получения кук: " + e.getMessage());
            return "";
        }
    }



    /**
     * Начальный запрос для получения сессии и Referer
     */
    private void makeInitialRequest(School school) {
        try {
            String initialUrl = SGOHttpPath.BASE_HOST + "authorize/login?back=1";
            HttpRequest initialRequest = HttpRequest.newBuilder()
                    .uri(URI.create(initialUrl))
                    .header("User-Agent", "Mozilla/5.0 (SGO-Client/1.0)")
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                    .GET()
                    .build();

            HttpResponse<Void> response = httpClient.send(initialRequest, HttpResponse.BodyHandlers.discarding());
        } catch (Exception e) {
            System.out.println("  ⚠️  Ошибка начального запроса: " + e.getMessage());
        }
    }


    @Override
    public void close() {
        refresher.stopRefreshLoop();
        asyncExecutor.shutdownNow();
        asyncExecutor.close();
        httpClient.shutdownNow();
        httpClient.close();
    }
}
