package com.charms.user.dao.mapper;

import com.charms.user.dao.model.UserBase;
import java.util.List;

public interface UserBaseMapper {
    int deleteByPrimaryKey(Long uid);

    int insert(UserBase record);

    UserBase selectByPrimaryKey(Long uid);

    List<UserBase> selectAll();

    int updateByPrimaryKey(UserBase record);
}