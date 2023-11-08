package com.example.fundyassignment.common;

import lombok.val;

public enum UserAuthority {
    NORMAL("NORMAL"),
    CREATOR("CREATOR");

    private String value;

    UserAuthority(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
