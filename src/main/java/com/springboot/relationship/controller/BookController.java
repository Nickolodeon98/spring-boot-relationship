package com.springboot.relationship.controller;

import com.springboot.relationship.domain.entity.Book;
import com.springboot.relationship.service.AuthorService;
import com.springboot.relationship.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String selectEveryBook() {
        List<Book> books = bookService.getAllBooks();
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.toString());
            sb.append(authorService.getSingleAuthor(book.getAuthor().getId()).toString());
        }
        return sb.toString();
    }
}

