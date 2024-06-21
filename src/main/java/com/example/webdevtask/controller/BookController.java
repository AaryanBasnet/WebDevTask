package com.example.webdevtask.controller;

import com.example.webdevtask.entity.Book;
import com.example.webdevtask.pojo.BookPojo;
import com.example.webdevtask.service.BookService;
import com.example.webdevtask.shared.pojo.GlobalApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity<GlobalApiResponse<List<Book>>> getData() {
        List<Book> books = bookService.getAll();
        GlobalApiResponse<List<Book>> response = GlobalApiResponse.<List<Book>>builder()
                .data(books)
                .statusCode(HttpStatus.OK.value())
                .message("Data retrieved successfully!")
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<GlobalApiResponse<Void>> save(@Valid @RequestBody BookPojo bookPojo) {
        bookService.saveData(bookPojo);
        GlobalApiResponse<Void> response = GlobalApiResponse.<Void>builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("Book saved successfully!")
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GlobalApiResponse<Optional<Book>>> getData(@PathVariable Integer id) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            GlobalApiResponse<Optional<Book>> response = GlobalApiResponse.<Optional<Book>>builder()
                    .data(book)
                    .statusCode(HttpStatus.OK.value())
                    .message("Data retrieved successfully!")
                    .build();
            return ResponseEntity.ok(response);
        } else {
            GlobalApiResponse<Optional<Book>> response = GlobalApiResponse.<Optional<Book>>builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .message("Book not found")
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GlobalApiResponse<Void>> delete(@PathVariable Integer id) {
        if (bookService.deleteById(id)) {
            GlobalApiResponse<Void> response = GlobalApiResponse.<Void>builder()
                    .statusCode(HttpStatus.OK.value())
                    .message("Book deleted successfully!")
                    .build();
            return ResponseEntity.ok(response);
        } else {
            GlobalApiResponse<Void> response = GlobalApiResponse.<Void>builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .message("Book not found")
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody BookPojo bookPojo) {
        bookService.updateData(id, bookPojo);
    }
}
