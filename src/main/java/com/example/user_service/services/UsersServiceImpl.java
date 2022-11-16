package com.example.user_service.services;

import com.example.user_service.dtos.GroupDto;
import com.example.user_service.dtos.UserDto;
import com.example.user_service.entities.GroupEntity;
import com.example.user_service.entities.UserEntity;
import com.example.user_service.exceptions.ApiRequestException;
import com.example.user_service.repositories.UserGroupRepository;
import com.example.user_service.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Group;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    private final UserGroupRepository groupRepository;

    @Override
    public UserDto registerUser(UserDto userDTO) {
        UserEntity existingUser = usersRepository.findById(userDTO.getId()).orElse(null);
        if (existingUser == null) {
            UserEntity userEntity = new UserEntity();
            userEntity.setName(userDTO.getName());
            usersRepository.save(userEntity);
            return userDTO;
        } else {
            throw new ApiRequestException("User with this ID is not exist.");
        }
    }

    @Override
    public void updateCustomerGroup(UserDto userDto) {
        GroupDto group= groupRepository.findByCode("ADMIN");
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setCode(group.getCode());
        groupEntity.setName(group.getName());
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.addUserGroups(groupEntity);
    }

    @Override
    public UserDto findById(Integer id) {
        UserEntity userEntity = usersRepository.findById(id).orElseThrow(() ->
               new RuntimeException("Not found owner with id" + id));
        UserDto userDTO = new UserDto();
        userDTO.setName(userEntity.getName());
        return userDTO;
    }
}
