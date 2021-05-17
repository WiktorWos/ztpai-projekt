package com.wiktor.wos.server.service.mapper;

import com.wiktor.wos.server.entity.User;
import com.wiktor.wos.server.service.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<User, UserDTO> {

}