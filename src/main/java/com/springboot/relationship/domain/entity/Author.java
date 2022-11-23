package com.springboot.relationship.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String authorName;

    @OneToMany(mappedBy = "author", targetEntity = Book.class)
    private List<Book> books = new ArrayList<>();

    @Override
    public String toString() {
        return " " + authorName + "\n";
    }
}
