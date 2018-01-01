package com.charms.user.dao.model;

import java.util.Date;

public class UserAuth {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_auth.id
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_auth.uid
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_auth.identity_type
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Byte identityType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_auth.identifier
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private String identifier;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_auth.certificate
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private String certificate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_auth.create_time
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_auth.update_time
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_auth.remove_status
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Byte removeStatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_auth.id
     *
     * @return the value of user_auth.id
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_auth.id
     *
     * @param id the value for user_auth.id
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_auth.uid
     *
     * @return the value of user_auth.uid
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_auth.uid
     *
     * @param uid the value for user_auth.uid
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_auth.identity_type
     *
     * @return the value of user_auth.identity_type
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    public Byte getIdentityType() {
        return identityType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_auth.identity_type
     *
     * @param identityType the value for user_auth.identity_type
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    public void setIdentityType(Byte identityType) {
        this.identityType = identityType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_auth.identifier
     *
     * @return the value of user_auth.identifier
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_auth.identifier
     *
     * @param identifier the value for user_auth.identifier
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier == null ? null : identifier.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_auth.certificate
     *
     * @return the value of user_auth.certificate
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    public String getCertificate() {
        return certificate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_auth.certificate
     *
     * @param certificate the value for user_auth.certificate
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    public void setCertificate(String certificate) {
        this.certificate = certificate == null ? null : certificate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_auth.create_time
     *
     * @return the value of user_auth.create_time
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_auth.create_time
     *
     * @param createTime the value for user_auth.create_time
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_auth.update_time
     *
     * @return the value of user_auth.update_time
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_auth.update_time
     *
     * @param updateTime the value for user_auth.update_time
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_auth.remove_status
     *
     * @return the value of user_auth.remove_status
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    public Byte getRemoveStatus() {
        return removeStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_auth.remove_status
     *
     * @param removeStatus the value for user_auth.remove_status
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    public void setRemoveStatus(Byte removeStatus) {
        this.removeStatus = removeStatus;
    }
}