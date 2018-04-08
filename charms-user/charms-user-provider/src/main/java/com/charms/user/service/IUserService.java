package com.charms.user.service;

import com.charms.user.dao.model.UserBase;
import com.charms.user.dao.model.UserExtra;
import com.charms.user.dao.model.UserLocation;

public interface IUserService {

    UserBase addOrUpdateBase(UserBase userBase);

    UserExtra addOrUpdateExtra(UserExtra userExtra);

    UserLocation addLocation(UserLocation userLocation);

}
