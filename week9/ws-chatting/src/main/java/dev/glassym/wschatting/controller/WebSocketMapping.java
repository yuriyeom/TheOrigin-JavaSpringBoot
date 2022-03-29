package dev.glassym.wschatting.controller;

import dev.glassym.wschatting.model.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebSocketMapping {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketMapping.class);

    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebSocketMapping(
            @Autowired SimpMessagingTemplate simpMessagingTemplate
    ){
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/ws/chat") // @RequestMapping과 비슷
    public void sendChat(ChatMessage chatMessage){ // @RequestBody와 비슷
        logger.info(chatMessage.toString());
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        chatMessage.setTime(time);
        simpMessagingTemplate.convertAndSend(
                // 이 destination을 구독하고 있는 클라이언트에게만 메세지를 보낸다
                String.format("/receive-endpoint/%s", chatMessage.getRoomId()),
                chatMessage// 실제로 보낼 메시지
        );
    }

//    // 단체 채팅방을 만들고싶다. destination 변동이 필요없다.
//    @MessageMapping("/ws/chat")
//    @SendTo("/receive-endpoint/all")
//    public ChatMessage sendChatAll(){
//
//    }
}
