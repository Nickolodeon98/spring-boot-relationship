package com.springboot.relationship.domain.dto;

import com.springboot.relationship.domain.entity.Hospital;
import com.springboot.relationship.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class HospitalResponse {

    private Integer id;
    private String roadNameAddress;

    private List<Review> reviews;

    public Hospital toEntity() {
        return Hospital.builder()
                .id(id)
                .roadNameAddress(this.roadNameAddress)
                .build();
    }
}
