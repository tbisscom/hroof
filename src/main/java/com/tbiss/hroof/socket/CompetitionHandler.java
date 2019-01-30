package com.tbiss.hroof.socket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CompetitionHandler extends TextWebSocketHandler {

    private List<WebSocketSession> sessionList = new CopyOnWriteArrayList<>();


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionList.add(session);
    }


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)  {
        for (WebSocketSession webSocketSession:sessionList){
            try {

                TextMessage message1 = new TextMessage(message.getPayload().toUpperCase());
                webSocketSession.sendMessage(message1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
