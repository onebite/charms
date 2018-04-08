package com.charms.user.enums;

public enum UserRoleEnum {
    BEAUTY_CUSTOMER(2000,"美人客户"),
    BEAUTY_DRESSER(2001,"美容造型");

    private int code;
    private String description;

    UserRoleEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
