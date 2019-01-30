package com.tbiss.hroof.api.v1.mapper;

import com.tbiss.hroof.api.v1.model.user.UserDTO;
import com.tbiss.hroof.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper()
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );


    UserDTO userToUserDTO(User user);
}
