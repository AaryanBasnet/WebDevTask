package com.example.webdevtask.service;

import com.example.webdevtask.entity.Ground;
import com.example.webdevtask.pojo.BookPojo;
import com.example.webdevtask.pojo.GroundPojo;

import java.util.List;
import java.util.Optional;

public interface GroundService {

    void saveData(GroundPojo groundPojo);
    List<Ground> getAll();
    void updateData(Long id, GroundPojo groundPojo);

    void deleteById(Integer id);
    Optional<Ground> findById(Integer id);
}