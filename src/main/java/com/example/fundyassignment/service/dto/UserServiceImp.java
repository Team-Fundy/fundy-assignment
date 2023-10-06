package com.example.fundyassignment.service.dto;

import com.example.fundyassignment.repository.User;
import com.example.fundyassignment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.fundyassignment.service.UserService;
import com.example.fundyassignment.service.dto.request.UserSaveServiceRequest;
import com.example.fundyassignment.service.dto.response.UserInfoServiceResponse;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Override
    public long saveUser(UserSaveServiceRequest request) {
        User user = userRepository.save(User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .authority(request.getAuthority())
                .pnumber(request.getPnumber())
                .build());

        return user.getId();
    }

    @Override
    public UserInfoServiceResponse findById(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("No User"));
        

        return UserInfoServiceResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .authority(user.getAuthority())
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
                .authority(user.getAuthority())
                .pnumber(user.getPnumber())
                .build();

    }





}
