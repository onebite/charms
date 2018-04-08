package com.charms.user.enums;

public enum GenderEnum {
    FEMALE("female"),
    MALE("male");

    private String description;

    GenderEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
