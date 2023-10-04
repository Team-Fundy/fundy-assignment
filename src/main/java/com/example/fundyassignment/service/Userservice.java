package com.example.fundyassignment.service;

import com.example.fundyassignment.service.dto.request.UserSaveServiceRequest;
import com.example.fundyassignment.service.dto.response.UserInfoServiceResponse;

public interface Userservice {
    public long saveUser(UserSaveServiceRequest request);
    public UserInfoServiceResponse findById(long id);

}
