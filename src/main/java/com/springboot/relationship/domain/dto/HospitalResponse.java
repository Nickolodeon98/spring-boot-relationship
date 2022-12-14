package com.springboot.relationship.domain.dto;

import com.springboot.relationship.domain.entity.Hospital;
import com.springboot.relationship.domain.entity.Review;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class HospitalResponse {

    private Integer id;

    private String hospitalName;
    private String roadNameAddress;

    private List<ReviewResponse> reviews;

    public Hospital toEntity() {
        return Hospital.builder()
                .id(id)
                .roadNameAddress(this.roadNameAddress)
                .build();
    }
}
