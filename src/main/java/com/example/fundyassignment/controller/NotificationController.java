package com.example.fundyassignment.controller;

import com.example.fundyassignment.controller.dto.request.SaveUserRequest;
import com.example.fundyassignment.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.objenesis.instantiator.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

//    @GetMapping("/subscribe")
//    public SseEmitter subscribe(Authentication authentication) {
//        SaveUserRequest saveUserRequest = ClassUtils.getCastInstance(authentication.getPrincipal(), saveUserRequest.class);
//
//
//    }

}
