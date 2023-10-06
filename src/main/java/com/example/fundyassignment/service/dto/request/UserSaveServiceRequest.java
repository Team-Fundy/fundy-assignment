package com.example.fundyassignment.service.dto.request;


import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserSaveServiceRequest {
    private String email;
    private String password;
    private String nickname;
    private String authority;
    private String pnumber;

}
