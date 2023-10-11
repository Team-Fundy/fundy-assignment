package com.example.fundyassignment.service.dto.response;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostInfoServiceResponse {
    private long id;
    private String title;
    private String text;
    private long userid;
}
