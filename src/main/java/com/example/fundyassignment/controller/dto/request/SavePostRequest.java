package com.example.fundyassignment.controller.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SavePostRequest {

    @NotNull
    @Length(min = 50, max = 1000)
    private String title;

    @NotNull
    private String text;

    @NotNull
    private String nickname;
}
