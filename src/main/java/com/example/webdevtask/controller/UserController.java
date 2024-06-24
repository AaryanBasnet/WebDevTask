package com.example.webdevtask.controller;

import com.example.webdevtask.entity.User;
import com.example.webdevtask.pojo.GroundPojo;
import com.example.webdevtask.pojo.UserPojo;
import com.example.webdevtask.service.UserService;
import com.example.webdevtask.shared.pojo.GlobalApiResponse;

import lombok.RequiredArgsConstructor;
//import org.springframework.validation.annotation.Validated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")

    public GlobalApiResponse<List<User>> getData() {
        return GlobalApiResponse.
                <List<User>>builder()
                .data(userService.getAll())
                .statusCode(200)
                .message("Data retrieved successfully!")
                .build();
    }

    @PostMapping("/save")
    public void save(@RequestBody  UserPojo userPojo) {
        this.userService.saveData(userPojo);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<GlobalApiResponse<Void>> update(@PathVariable Long id, @RequestBody UserPojo userPojo) {
        userService.updateData(id, userPojo);
        GlobalApiResponse<Void> response = GlobalApiResponse.<Void>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Book updated successfully!")
                .build();
        return ResponseEntity.ok(response);
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