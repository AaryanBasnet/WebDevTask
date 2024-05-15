package com.example.webdevtask.service.implementor;

import com.example.webdevtask.entity.Book;
import com.example.webdevtask.pojo.BookPojo;
import com.example.webdevtask.repo.BookRepo;
import com.example.webdevtask.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookImpl implements BookService {

    private final BookRepo bookRepo;

    @Override
    public void saveData(BookPojo bookPojo) {
        Book book = new Book();
        book.setBookingId(bookPojo.getBookingId());
        book.setUserName(bookPojo.getUserName());
        bookRepo.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        bookRepo.deleteById(Long.valueOf(id));
    }

    @Override
    public Optional<Book> findById(Integer bookingId) {
        return bookRepo.findById(Long.valueOf(bookingId));
    }
}