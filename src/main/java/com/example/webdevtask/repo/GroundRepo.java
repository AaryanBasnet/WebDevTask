package com.example.webdevtask.repo;

import com.example.webdevtask.entity.Ground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroundRepo extends JpaRepository<Ground, Long> {

}