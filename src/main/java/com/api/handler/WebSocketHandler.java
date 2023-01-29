package com.api.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 *
 * @author Miguel Castro
 */
@Component
public class WebSocketHandler extends TextWebSocketHandler {
    
    //Método para estabelecer a conexão.
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        
    }
    
    //Método para exibição dos dados tráfegados quando a conexão estiver estabelecida.
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {

    }
    
    //Método para fechar a conexão.
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {

    }
}
