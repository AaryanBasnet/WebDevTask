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
        book.setGround(bookPojo.getGround());
        book.setUser(bookPojo.getUser());

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

    @Override
    public void updateData(Long id, BookPojo bookPojo) {
        Optional<Book> existingBookOpt = bookRepo.findById(id);
        if (existingBookOpt.isPresent()) {
            Book existingBook = existingBookOpt.get();
            existingBook.setUserName(bookPojo.getUserName());
            existingBook.setGround(bookPojo.getGround());
            existingBook.setUser(bookPojo.getUser());

            bookRepo.save(existingBook);
        } else {
            throw new RuntimeException("Book not found with id " + id);
        }
    }
}
