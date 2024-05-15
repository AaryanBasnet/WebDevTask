package com.example.webdevtask.controller;

import com.example.webdevtask.entity.User;
import com.example.webdevtask.pojo.UserPojo;
import com.example.webdevtask.service.UserService;
import com.example.webdevtask.shared.pojo.GlobalApiResponse;

import lombok.RequiredArgsConstructor;
//import org.springframework.validation.annotation.Validated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public GlobalApiResponse<User> getData() {
        return GlobalApiResponse.
                <User>builder()
                .data("saved")
                .statusCode(200)
                .message("Data retrieved successfully!")
                .build();
    }

    @PostMapping("/save")
    public void save(@RequestBody  UserPojo userPojo) {
        this.userService.saveData(userPojo);
    }



    @GetMapping("/get/{id}")
    public Optional<User> getData(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        this.userService.deleteById(id);
    }
}