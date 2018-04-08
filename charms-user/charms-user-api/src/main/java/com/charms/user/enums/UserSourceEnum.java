package com.charms.user.enums;

/**
 * 1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪微博
 */
public enum UserSourceEnum {
    MOBILE((byte)1,"手机号注册"),
    EMAIL((byte)2,"邮箱邮箱注册"),
    USER_NAME((byte)3,"用户名"),
    QQ((byte)4,"QQ"),
    WEBCHAT((byte)5,"微信"),
    TENCENT_MICRO_BLOG((byte)6,"腾讯微博"),
    SINA_MICRO_BLOG((byte)7,"新浪微博");


    private byte code;
    private String description;

    UserSourceEnum(byte code, String description) {
        this.code = code;
        this.description = description;
    }

    public byte getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
