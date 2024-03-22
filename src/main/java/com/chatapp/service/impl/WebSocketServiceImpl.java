package com.chatapp.service.impl;

import com.chatapp.model.Message;
import com.chatapp.service.WebSocketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class WebSocketServiceImpl implements WebSocketService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Override
    public Mono<String> sendMessageToSubscribers(Message message) {
        log.info(Thread.currentThread().getName());
        return Mono.defer(()->{
            log.info(Thread.currentThread().getName());
            simpMessagingTemplate.convertAndSend("/topic/return-to", message);
            return Mono.just("Message sent successfully");
        });
    }

}
