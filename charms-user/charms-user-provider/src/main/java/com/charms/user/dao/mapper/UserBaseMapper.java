package com.charms.user.dao.mapper;

import com.charms.user.dao.model.UserBase;
import java.util.List;

public interface UserBaseMapper {
    int deleteByPrimaryKey(Long uid);

    int insert(UserBase record);

    UserBase selectByPrimaryKey(Long uid);

    List<UserBase> selectAll();

    int updateByPrimaryKey(UserBase record);

    /**
     * 邮箱唯一
     * @param email
     * @return
     */
    UserBase selectByEmail(String email);

    /**
     * 电话唯一
     * @param mobile
     * @return
     */
    UserBase selectByMobile(String mobile);
}