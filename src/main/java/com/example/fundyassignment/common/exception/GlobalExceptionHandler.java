package com.example.fundyassignment.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NoAuthorityException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GlobalExceptionResponse handleNoAuthorityException(final NoAuthorityException e) {
        return GlobalExceptionResponse.builder()
                .success(false)
                .message("Authority가 맞지 않습니다.")
                .build();
    }
}
