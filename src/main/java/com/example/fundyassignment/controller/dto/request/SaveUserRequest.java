package com.example.fundyassignment.controller.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SaveUserRequest {
    @Email
    @NotNull
    private String email;
    @NotNull
    @Length(min = 8, max = 20)
    private String password;
    private String nickname;
}
