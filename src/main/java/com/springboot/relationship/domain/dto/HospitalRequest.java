package com.springboot.relationship.domain.dto;

import com.springboot.relationship.domain.entity.Hospital;
import lombok.*;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Builder
public class HospitalRequest {
    private String hospitalName;
    private String roadNameAddress;

    public Hospital toEntity() {
        return Hospital.builder()
                .hospitalName(this.hospitalName)
                .roadNameAddress(this.roadNameAddress)
                .build();
    }
}
