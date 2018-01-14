package com.charms.user.dao.mapper;

import com.charms.user.dao.model.UserAuth;
import java.util.List;

public interface UserAuthMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserAuth record);

    UserAuth selectByPrimaryKey(Long id);

    List<UserAuth> selectAll();

    int updateByPrimaryKey(UserAuth record);
}