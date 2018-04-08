package com.charms.user.facade;

import com.charms.user.dto.UserDTO;

public interface IUserFacade {

    int addOrUpdate(UserDTO userDTO);
}
