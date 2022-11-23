package com.springboot.relationship.service;

import com.springboot.relationship.domain.entity.Book;
import com.springboot.relationship.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksWithAuthors(Integer id) {
        return bookRepository.findByAuthor_Id(id);
    }
}
