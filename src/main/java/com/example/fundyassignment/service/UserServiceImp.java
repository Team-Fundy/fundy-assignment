package com.example.fundyassignment.service;

import com.example.fundyassignment.common.UserAuthority;
import com.example.fundyassignment.common.exception.NoAuthorityException;
import com.example.fundyassignment.jwttoken.JwtTokenProvider;
import com.example.fundyassignment.repository.User;
import com.example.fundyassignment.repository.UserRepository;
import com.example.fundyassignment.service.dto.response.UserInfoServiceResponse;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.fundyassignment.service.dto.request.UserSaveServiceRequest;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    @Override
    public String saveUser(UserSaveServiceRequest request) {
        try {
            UserAuthority authority = UserAuthority.valueOf(request.getAuthority());
            User user = userRepository.save(User.builder()
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .nickname(request.getNickname())
                    .authority(authority)
                    .pnumber(request.getPnumber())
                    .build());

            return String.valueOf(user.getId());
            //return user.getId();
        } catch (Exception e) {
            throw NoAuthorityException.getBasic();

        }
    }

    @Override
    public UserInfoServiceResponse findById(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("No User"));

        return UserInfoServiceResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .authority(user.getAuthority().getValue())
                .pnumber(user.getPnumber())
                .build();
    }

    @Override
    public UserInfoServiceResponse findByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("No User"));

        return UserInfoServiceResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .authority(user.getAuthority().getValue())
                .pnumber(user.getPnumber())
                .build();

    }

//    @Override
//    public UserInfoServiceResponse findByToken(String token) {
//        return jwtTokenProvider.getUserInfo(token);
//    }






}
