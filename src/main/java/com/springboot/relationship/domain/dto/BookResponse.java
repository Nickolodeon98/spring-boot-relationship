package com.springboot.relationship.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class BookResponse {

    private Integer id;
    private String bookTitle;
    private String authorName;
    private String publisherName;

    @Override
    public String toString() {
        return "BookResponse{" +
                "id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
