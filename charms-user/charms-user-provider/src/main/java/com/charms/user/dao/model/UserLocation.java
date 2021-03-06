package com.charms.user.dao.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserLocation {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_location.uid
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_location.curr_nation
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private String currNation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_location.curr_province
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private String currProvince;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_location.curr_city
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private String currCity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_location.curr_district
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private String currDistrict;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_location.location
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private String location;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_location.longitude
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private BigDecimal longitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_location.latitude
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private BigDecimal latitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_location.create_time
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_location.update_time
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_location.remove_status
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    private Byte removeStatus;

}