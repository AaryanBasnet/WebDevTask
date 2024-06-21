package com.example.webdevtask.controller;

import com.example.webdevtask.entity.Ground;
import com.example.webdevtask.pojo.GroundPojo;
import com.example.webdevtask.service.GroundService;
import com.example.webdevtask.shared.pojo.GlobalApiResponse;
//import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ground")
@RequiredArgsConstructor
public class GroundController {

    private final GroundService groundService;

    @GetMapping("/get")

    public GlobalApiResponse<List<Ground>> getData() {
        return GlobalApiResponse.
                <List<Ground>>builder()
                .data(groundService.getAll())
                .statusCode(200)
                .message("Data retrieved successfully!")
                .build();
    }
    @PostMapping("/save")
    public void save(@RequestBody GroundPojo groundPojo) {
        this.groundService.saveData(groundPojo);
    }

    @GetMapping("/get/{id}")
    public Optional<Ground> getData(@PathVariable Integer id) {
        return groundService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        this.groundService.deleteById(id);
    }
}