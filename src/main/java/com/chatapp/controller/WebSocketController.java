package com.chatapp.controller;

import com.chatapp.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class WebSocketController {



    @MessageMapping("/message")
    @SendTo("/topic/return-to")
    public Message sendMessage(@RequestBody Message message){
        return message;
    }

}
