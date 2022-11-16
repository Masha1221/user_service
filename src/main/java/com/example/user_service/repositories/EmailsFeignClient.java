package com.example.user_service.repositories;

import com.example.user_service.dtos.EmailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "email_service", path = "/emails")
public interface EmailsFeignClient {

    @PostMapping()
    void sendEmail(@RequestBody EmailDto emailDto);
//object->JSON->object
}
