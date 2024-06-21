package com.example.webdevtask.pojo;

import com.example.webdevtask.entity.Ground;
import com.example.webdevtask.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookPojo {
    private Integer bookingId;
    private String userName;
    private Ground ground;
    private User user;
}