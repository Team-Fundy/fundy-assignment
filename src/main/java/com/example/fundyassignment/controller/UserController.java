package com.example.fundyassignment.controller;


import com.example.fundyassignment.controller.dto.request.SaveUserRequest;
import com.example.fundyassignment.jwttoken.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
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
    public final long saveUser(@RequestBody SaveUserRequest request){
        return userService.saveUser(UserSaveServiceRequest.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .authority(request.getAuthority())
                .pnumber(request.getPnumber())
                .build());
    }

    //토큰 사용

    @PostMapping("/token")
    public final void login(@RequestBody SaveUserRequest request) {
        String nickname = request.getNickname();
        String email = request.getEmail();
        String authority = request.getAuthority();

        jwtTokenProvider.createToken(nickname, email, authority);
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
