package com.springboot.relationship.domain.entity;

import com.springboot.relationship.domain.dto.BookResponse;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String bookTitle;

    @ManyToOne
    private Author author;

    @OneToOne
    private Publisher publisher;

    @Override
    public String toString() {
        return bookTitle;
    }

    public static BookResponse of(Book book) {
        return new BookResponse(book.getId(), book.getBookTitle(), book.getAuthor().getAuthorName(), book.getPublisher().getPublisherName());
    }
}
