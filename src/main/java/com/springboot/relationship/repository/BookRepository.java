package com.springboot.relationship.repository;

import com.springboot.relationship.domain.entity.Author;
import com.springboot.relationship.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByAuthor_Id(Integer id); // join 해준다.
}
