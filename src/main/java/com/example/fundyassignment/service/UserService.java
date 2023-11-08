package com.example.fundyassignment.service;

import com.example.fundyassignment.service.dto.request.UserSaveServiceRequest;
import com.example.fundyassignment.service.dto.response.UserInfoServiceResponse;
import io.jsonwebtoken.Claims;

public interface UserService {
    public String saveUser(UserSaveServiceRequest request);
    public UserInfoServiceResponse findById(long id);
    public UserInfoServiceResponse findByEmail(String email);
//    public Claims findByToken(String token);

}
