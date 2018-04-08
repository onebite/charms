package com.charms.user.facade.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.charms.user.dto.UserDTO;
import com.charms.user.facade.IUserFacade;

@Service(protocol = "dubbo")
public class UserFacadeImpl implements IUserFacade{

    public int addOrUpdate(UserDTO userDTO) {

        return 0;
    }
}
