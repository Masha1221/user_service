package com.example.user_service.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Entity
@Accessors(chain = true)
@Data
@Table(name = "principle_groups")
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String code;
    private String name;

    @ManyToMany()
    private Set<UserEntity> users;
}
