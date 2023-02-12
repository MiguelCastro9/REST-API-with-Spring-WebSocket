package com.api.handler;

import com.api.dto.PessoaResponseDto;
import com.api.service.PessoaService;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Miguel Castro
 */
@Component
public class WebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private PessoaService pessoaService;
    private static Logger logger = LogManager.getLogger(TextWebSocketHandler.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {

        logger.info("conexão estabelecida.");

        //Servidor enviando dados para o client em tempo real.
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    session.sendMessage(new TextMessage(
                            pessoaService.listar().stream().map(pessoa
                                    -> PessoaResponseDto.converterEntidadeParaPessoaDto(pessoa))
                                    .collect(Collectors.toList()).toString()));
                } catch (IOException ex) {
                    ex.getStackTrace();
                }
            }
        }, 1000L, 2000L);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        logger.info("conexão fechada.");
    }
}
