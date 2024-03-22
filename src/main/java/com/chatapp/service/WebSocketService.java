package com.chatapp.service;

import com.chatapp.model.Message;
import reactor.core.publisher.Mono;

public interface WebSocketService {

    Mono<String> sendMessageToSubscribers(Message message);
}
