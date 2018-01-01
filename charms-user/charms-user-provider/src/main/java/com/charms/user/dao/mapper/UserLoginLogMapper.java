package com.charms.user.dao.mapper;

import com.charms.user.dao.model.UserLoginLog;
import java.util.List;

public interface UserLoginLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    int insert(UserLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    UserLoginLog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    List<UserLoginLog> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbggenerated Mon Jan 01 16:18:15 CST 2018
     */
    int updateByPrimaryKey(UserLoginLog record);
}