package com.springboot.relationship.controller;

import com.springboot.relationship.domain.dto.BookResponse;
import com.springboot.relationship.domain.entity.Book;
import com.springboot.relationship.service.AuthorService;
import com.springboot.relationship.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookResponse>> selectEveryBook() {
        List<Book> books = bookService.getAllBooks();
        List<BookResponse> foundBooks = new ArrayList<>();
        for (Book book : books) {
            foundBooks.add(Book.of(book));
        }
        return ResponseEntity.ok().body(foundBooks);
    }
}

