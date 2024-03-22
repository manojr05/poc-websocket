package com.chatapp.controller;

import com.chatapp.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @MessageMapping("/message")
    @SendTo("/topic/return-to")
    public Message sendMessage(@RequestBody Message message){
        return message;
    }

}
