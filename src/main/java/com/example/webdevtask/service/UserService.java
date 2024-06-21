package com.example.webdevtask.service;

import com.example.webdevtask.entity.User;
import com.example.webdevtask.pojo.UserPojo;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void saveData(UserPojo userPojo);
    List<User> getAll();

    void deleteById(Integer id);
    Optional<User> findById(Integer id);
}