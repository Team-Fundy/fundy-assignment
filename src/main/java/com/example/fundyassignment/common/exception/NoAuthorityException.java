package com.example.fundyassignment.common.exception;

public class NoAuthorityException extends RuntimeException{
    private NoAuthorityException() {
        super("권한이 없습니다.");
    }

    public static NoAuthorityException getBasic() {
        return new NoAuthorityException();
    }
}
