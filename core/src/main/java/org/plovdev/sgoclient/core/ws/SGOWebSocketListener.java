package org.plovdev.sgoclient.core.ws;

public interface SGOWebSocketListener {
    void onOpen();

    void onMessage(String message);

    void onClosed(int code, String reason);

    void onFailure(Throwable t);
}