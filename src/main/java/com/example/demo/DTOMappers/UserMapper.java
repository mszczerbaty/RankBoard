package com.example.demo.DTOMappers;

import com.example.demo.DTOs.UserDTO;
import com.example.demo.Entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(User user);
    User toUser(UserDTO userDTO);
}
