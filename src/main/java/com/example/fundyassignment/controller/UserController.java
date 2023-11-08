package com.example.fundyassignment.controller;


import com.example.fundyassignment.controller.dto.request.SaveUserRequest;
import com.example.fundyassignment.jwttoken.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import ognl.Token;
import org.springframework.web.bind.annotation.*;
import com.example.fundyassignment.service.UserService;
import com.example.fundyassignment.service.dto.request.UserSaveServiceRequest;
import com.example.fundyassignment.service.dto.response.UserInfoServiceResponse;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping
    public final String saveUser(@RequestBody SaveUserRequest request){

        //String token = jwtTokenProvider.createToken(request.getEmail(), request.getAuthority());

//        return userService.saveUser(UserSaveServiceRequest.builder()
//                .email(request.getEmail())
//                .password(request.getPassword())
//                .nickname(request.getNickname())
//                .authority(request.getAuthority())
//                .pnumber(request.getPnumber())
//                .build());
        userService.saveUser(UserSaveServiceRequest.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .authority(request.getAuthority())
                .pnumber(request.getPnumber())
                .build());
        return jwtTokenProvider.createToken(request.getEmail(), request.getAuthority());

    }

    //토큰에서 이메일 추출
    @GetMapping("/token/{token}")
    public final String getByToken(@PathVariable(name = "token") String token) {
        return (String) jwtTokenProvider.getUserInfo(token).get("email");

    }

    @GetMapping("/id/{id}")
    public final UserInfoServiceResponse getUserById(@PathVariable(name = "id") long id){
        return userService.findById(id);
    }
    @GetMapping("/email/{email}")
    public final UserInfoServiceResponse getUserByEmail(@PathVariable(name = "email") String email){
        return userService.findByEmail(email);
    }
}
