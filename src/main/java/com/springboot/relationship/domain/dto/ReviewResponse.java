package com.springboot.relationship.domain.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewResponse {

    private String title;
    private String patientName;
    private String contents;

}
