package com.example.fundyassignment.service.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserInfoServiceResponse {
    private String email;
    private String nickname;
}
