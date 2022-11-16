package com.example.user_service.controllers;

import com.example.user_service.dtos.UserDto;
import com.example.user_service.services.UsersServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
public class UsersController {

    private final UsersServiceImpl usersService;

    @PostMapping("/users")
    public ResponseEntity<HttpStatus> registryUser(@RequestBody UserDto userDTO) {
        usersService.registerUser(userDTO);
        log.info("The user {} has been successfully registered.", userDTO.getName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/admin/users/{id}")
    public ResponseEntity<HttpStatus> updateCostumerGroup(@PathVariable Integer id) {
        UserDto userDto = usersService.findById(id);
        usersService.updateCustomerGroup(userDto);
        log.info("The group for user with id {} has been successfully updated.", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


