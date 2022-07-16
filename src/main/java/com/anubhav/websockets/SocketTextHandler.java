package com.anubhav.websockets;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Component
public class SocketTextHandler extends TextWebSocketHandler {

    private WebSocketSessionManager webSocketSessionManager;

    public SocketTextHandler(WebSocketSessionManager webSocketSessionManager) {
        this.webSocketSessionManager = webSocketSessionManager;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        this.webSocketSessionManager.addWebSocketSession(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        this.webSocketSessionManager.removeWebSocketSession(session);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws IOException {
        String payload = message.getPayload();
        this.webSocketSessionManager.getWebSocketSessionsExcept(session).forEach(webSocketSession -> {
            try {
                webSocketSession.sendMessage(new TextMessage("message = "+payload));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}