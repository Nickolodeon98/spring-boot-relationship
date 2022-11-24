package com.springboot.relationship.domain.dto;

import com.springboot.relationship.domain.entity.Review;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReviewRequest {

    private String title;
    private String patientName;
    private String contents;

    public Review toEntity() {
        return Review.builder()
                .title(this.title)
                .patientName(this.patientName)
                .contents(this.contents)
                .build();
    }
}
