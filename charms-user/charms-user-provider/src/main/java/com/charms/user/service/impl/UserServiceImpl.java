package com.charms.user.service.impl;

import com.charms.user.dao.mapper.UserBaseMapper;
import com.charms.user.dao.model.UserBase;
import com.charms.user.dao.model.UserExtra;
import com.charms.user.dao.model.UserLocation;
import com.charms.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements IUserService{
    @Autowired
    private UserBaseMapper userBaseMapper;

    public UserBase addOrUpdateBase(UserBase userBase) {

        return null;
    }

    public UserExtra addOrUpdateExtra(UserExtra userExtra) {
        return null;
    }

    public UserLocation addLocation(UserLocation userLocation) {
        return null;
    }
}
