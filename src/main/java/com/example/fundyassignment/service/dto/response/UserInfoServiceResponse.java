package com.example.fundyassignment.service.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserInfoServiceResponse {
    private long id;
    private String email;
    private String nickname;
    private String authority;
    private String pnumber;
}
