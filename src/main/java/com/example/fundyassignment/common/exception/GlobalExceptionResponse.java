package com.example.fundyassignment.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GlobalExceptionResponse extends Throwable {
    private boolean success;
    private String message;
}
