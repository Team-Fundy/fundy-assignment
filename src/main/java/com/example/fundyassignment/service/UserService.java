package com.example.fundyassignment.service;

import com.example.fundyassignment.service.dto.request.UserSaveServiceRequest;
import com.example.fundyassignment.service.dto.response.UserInfoServiceResponse;

public interface UserService {
    public long saveUser(UserSaveServiceRequest request);
    public UserInfoServiceResponse findById(long id);
    public UserInfoServiceResponse findByEmail(String email);

}
