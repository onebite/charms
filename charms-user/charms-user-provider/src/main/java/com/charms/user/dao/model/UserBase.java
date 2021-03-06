package com.charms.user.dao.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserBase {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.uid
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.user_role
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Integer userRole;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.register_source
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Byte registerSource;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.user_name
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.nick_name
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private String nickName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.gender
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Boolean gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.birthday
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Long birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.signature
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private String signature;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.mobile
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.mobile_bind_time
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Integer mobileBindTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.email
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.email_bind_time
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Integer emailBindTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.face
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private String face;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.face200
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private String face200;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.srcface
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private String srcface;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.create_time
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.update_time
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.remove_status
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Byte removeStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.push_token
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private String pushToken;


}