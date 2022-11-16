package com.example.user_service.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Accessors(chain = true)
@Data
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "user_groups",
            joinColumns =@JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"
            ))
    private Set<GroupEntity> userGroups = new HashSet<>();

    public void addUserGroups(GroupEntity group){
        userGroups.add(group);
        group.getUsers().add(this);
    }
}
