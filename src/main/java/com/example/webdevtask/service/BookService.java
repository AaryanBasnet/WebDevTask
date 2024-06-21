package com.example.webdevtask.service;

import com.example.webdevtask.entity.Book;
import com.example.webdevtask.pojo.BookPojo;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void saveData(BookPojo bookPojo);
    List<Book> getAll();

    boolean deleteById(Integer id);
    Optional<Book> findById(Integer id);

    void updateData(Long id,BookPojo bookPojo);
}