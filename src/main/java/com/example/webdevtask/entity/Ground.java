package com.example.webdevtask.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="grounds")
@Getter
@Setter
public class Ground {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="grounds_seq_gen")
    @SequenceGenerator(name="grounds_seq_gen",sequenceName="grounds_seq",allocationSize=1)
    @Id
    private Integer id;
    @Column(name ="ground_name",nullable = false,length = 100)
    private String name;
}