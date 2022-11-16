package com.example.user_service.repositories;

import com.example.user_service.dtos.GroupDto;
import com.example.user_service.entities.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupRepository extends PagingAndSortingRepository<GroupEntity, Integer> {

    GroupDto findByCode(String code);
}
