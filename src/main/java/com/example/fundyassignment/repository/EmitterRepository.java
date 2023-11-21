package com.example.fundyassignment.repository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@Slf4j
public class EmitterRepository {
    private final Map<String, SseEmitter> emitterMap = new HashMap<>();

    public SseEmitter save(Long userId, SseEmitter sseEmitter) {
        emitterMap.put(getKey(userId), sseEmitter);
        return sseEmitter;
    }

    public Optional<SseEmitter> get(Long userId) {
        log.info("Got SseEmitter for {}", userId);
        return Optional.ofNullable(emitterMap.get(getKey(userId)));
    }
    public void delete(Long userId) {

    }
    private String getKey(Long userId) {
        return "Emitter:UID:" + userId;
    }

}
