package com.example.webdevtask.controller;

import com.example.webdevtask.entity.Role;
import com.example.webdevtask.pojo.RolePojo;
import com.example.webdevtask.service.RoleService;
import com.example.webdevtask.shared.pojo.GlobalApiResponse;
//import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/get")
    public GlobalApiResponse<Role> getData() {
        return GlobalApiResponse.
                <Role>builder()
                .data("saved")
                .statusCode(200)
                .message("Data retrieved successfully!")
                .build();
    }

    @PostMapping("/save")
    public void save(@RequestBody RolePojo rolePojo) {
        this.roleService.saveData(rolePojo);
    }

    @GetMapping("/get/{id}")
    public Optional<Role> getData(@PathVariable Integer id) {
        return roleService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        this.roleService.deleteById(id);
    }
}