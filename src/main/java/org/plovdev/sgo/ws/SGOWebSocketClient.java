package org.plovdev.sgo.ws;

import okhttp3.*;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.plovdev.sgo.SGOSession;
import org.plovdev.sgo.http.SGOHttpPath;
import org.plovdev.sgo.http.requests.SGORequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class SGOWebSocketClient implements AutoCloseable {
    private static final Logger log = LoggerFactory.getLogger(SGOWebSocketClient.class);
    private final OkHttpClient client;
    private WebSocket webSocket;

    public SGOWebSocketClient(OkHttpClient client, SGOSession session) {
        this.client = Objects.requireNonNull(client);
    }

    public synchronized void connect(@NonNull SGORequest<?> req, SGOWebSocketListener listener) {
        Request request = new Request.Builder().url(SGOHttpPath.BASE_WS_HOST + req.endpoint()).build();
        webSocket = client.newWebSocket(request, new WebSocketListener() {
            @Override
            public void onOpen(@NonNull WebSocket webSocket, @NonNull Response response) {
                log.debug("WebSocket connection opened");
                listener.onOpen();
            }

            @Override
            public void onMessage(@NonNull WebSocket webSocket, @NonNull String message) {
                message = message.replace("\u001E", "");
                log.debug("Received message: {}", message);
                listener.onMessage(message);
            }

            @Override
            public void onClosed(@NonNull WebSocket webSocket, int code, @NonNull String reason) {
                log.debug("WebSocket connection closed. Code: {}, reason: {}", code, reason);
                listener.onClosed(code, reason);
            }

            @Override
            public void onFailure(@NonNull WebSocket webSocket, @NonNull Throwable t, @Nullable Response response) {
                log.error("WebSocket failure: ", t);
                listener.onFailure(t);
            }
        });
    }

    public synchronized void execute(SGORequest<?> request) {
        if (webSocket == null) {
            return;
        }
        String message = request.params();

        log.debug("Sending message: {}", message);
        webSocket.send(message);
    }

    @Override
    public void close() {
        webSocket.close(1000, "Fuck you:}");
    }
}