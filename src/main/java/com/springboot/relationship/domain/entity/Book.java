package com.springboot.relationship.domain.entity;

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

    @ManyToOne
    private Publisher publisher;

    @Override
    public String toString() {
        return bookTitle;
    }
}
