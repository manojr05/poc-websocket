package com.chatapp.controller;

import com.chatapp.model.Message;
import com.chatapp.service.WebSocketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/chat/publish")
@RequiredArgsConstructor
public class MessagePublisherController {

    private final WebSocketService webSocketService;

    @PostMapping
    public Mono<ResponseEntity<String>> publishMessage(@RequestBody Message message){
        log.info(Thread.currentThread().getName());
        return webSocketService.sendMessageToSubscribers(message)
                .flatMap(response -> {
                    log.info(Thread.currentThread().getName());
                    return Mono.just(ResponseEntity.ok("Message sent successfully"));
                });
    }


}
