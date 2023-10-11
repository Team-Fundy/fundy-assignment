package com.example.fundyassignment.service.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostSaveServiceRequest {
    private String title;
    private String text;
    private long userid;
}
