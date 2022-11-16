package com.example.user_service.services;

import com.example.user_service.dtos.UserDto;
import com.example.user_service.entities.UserEntity;

public interface UsersService {
    UserDto registerUser(UserDto userDTO);

    void updateCustomerGroup(UserDto userDto);

    UserDto findById(Integer id);
}
