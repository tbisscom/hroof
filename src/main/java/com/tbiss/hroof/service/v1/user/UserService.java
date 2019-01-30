package com.tbiss.hroof.service.v1.user;

import com.tbiss.hroof.api.v1.model.user.UserDTO;

public interface UserService {

    UserDTO findUserById(long id);
}
