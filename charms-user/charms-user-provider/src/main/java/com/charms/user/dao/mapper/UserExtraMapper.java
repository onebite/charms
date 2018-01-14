package com.charms.user.dao.mapper;

import com.charms.user.dao.model.UserExtra;
import java.util.List;

public interface UserExtraMapper {

    int deleteByPrimaryKey(Long uid);

    int insert(UserExtra record);

    UserExtra selectByPrimaryKey(Long uid);

    List<UserExtra> selectAll();

    int updateByPrimaryKey(UserExtra record);
}