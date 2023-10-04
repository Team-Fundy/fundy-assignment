package com.example.fundyassignment.controller;


import com.example.fundyassignment.controller.dto.request.SaveUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.fundyassignment.service.Userservice;
import com.example.fundyassignment.service.dto.request.UserSaveServiceRequest;
import com.example.fundyassignment.service.dto.response.UserInfoServiceResponse;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final Userservice userService;

    @PostMapping
    public final long saveUser(@RequestBody SaveUserRequest request){
        return userService.saveUser(UserSaveServiceRequest.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .build());
    }
    @GetMapping("/{id}")
    public final UserInfoServiceResponse getUserById(@PathVariable(name = "id") long id){
        return userService.findById(id);
    }

}
