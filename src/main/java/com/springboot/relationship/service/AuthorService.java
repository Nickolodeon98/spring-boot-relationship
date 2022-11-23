package com.springboot.relationship.service;

import com.springboot.relationship.domain.entity.Author;
import com.springboot.relationship.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getSingleAuthor(Integer id) {
        Optional<Author> foundAuthor = authorRepository.findById(id);
        return foundAuthor.orElse(null);
    }
}
