package com.chatapp.controller;

import com.chatapp.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/chat/publish")
@RequiredArgsConstructor
public class MessagePublisherController {

    private final WebSocketController webSocketController;

    @PostMapping
    public Mono<String> publishMessage(@RequestBody Message message){
        webSocketController.sendMessageToSubscribers(message);
        return Mono.just("Message sent successfully");
    }


}
