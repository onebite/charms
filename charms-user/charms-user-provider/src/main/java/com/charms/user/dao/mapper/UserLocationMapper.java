package com.charms.user.dao.mapper;

import com.charms.user.dao.model.UserLocation;
import java.util.List;

public interface UserLocationMapper {
    int deleteByPrimaryKey(Long uid);

    int insert(UserLocation record);
    UserLocation selectByPrimaryKey(Long uid);

    List<UserLocation> selectAll();

    int updateByPrimaryKey(UserLocation record);
}