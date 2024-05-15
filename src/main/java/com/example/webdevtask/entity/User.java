package com.example.webdevtask.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="users_seq_gen")
    @SequenceGenerator(name="users_seq_gen",sequenceName="users_seq",allocationSize=1)
    @Id
    private Integer Id;
    @Column(name="user_name" ,nullable=false, length=100)
    private String userName;
}