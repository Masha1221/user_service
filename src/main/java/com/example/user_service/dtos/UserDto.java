package com.example.user_service.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
public class UserDto {

    private int id;
    private String name;
}
