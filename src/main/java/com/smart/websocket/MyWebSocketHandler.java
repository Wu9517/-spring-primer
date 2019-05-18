package com.smart.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * @author wzy
 */
public class MyWebSocketHandler extends AbstractWebSocketHandler {


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        //处理文本消息
        System.out.println("收到消息" + message.getPayload());
        //模拟延时
        Thread.sleep(2000);
        //发送文本消息
        System.out.println("发送消息：hello world!");
        session.sendMessage(new TextMessage("hello world!"));
    }


}
