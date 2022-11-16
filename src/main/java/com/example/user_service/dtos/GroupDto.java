package com.example.user_service.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
public class GroupDto {

    private int id;
    private String code;
    private String name;
}
