package com.charms.user.dto;

import com.charms.user.enums.GenderEnum;
import com.charms.user.enums.UserRoleEnum;
import com.charms.user.enums.UserSourceEnum;

import java.util.Date;

public class UserDTO {
    /**
     * 用户ID
     */
    private Long uid;

    /**
     * 用户角色
     */
    private UserRoleEnum userRoleEnum;

    /**
     * 注册来源
     */
    private UserSourceEnum registerSourceEnum;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private GenderEnum genderEnum;

    /**
     * 生日
     */
    private Long birthday;

    /**
     * 用户个人签名
     */
    private String signature;

    /**
     * 手机
     */
    private String mobile;

    private Integer mobileBindTime;

    /**
     * 邮件
     */
    private String email;


    private Integer emailBindTime;

    /**
     * 头像
     */
    private String face;

    /**
     * 头像 200x200x80
     */
    private String face200;

    /**
     * 原头像
     */
    private String srcface;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 用户设备push_token
     */
    private String pushToken;
}
