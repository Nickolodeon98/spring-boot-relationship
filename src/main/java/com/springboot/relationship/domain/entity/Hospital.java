package com.springboot.relationship.domain.entity;

import com.springboot.relationship.domain.dto.HospitalResponse;
import com.springboot.relationship.domain.dto.ReviewResponse;
import lombok.*;

import javax.persistence.*;
import javax.sound.sampled.ReverbType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "hospitals")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String hospitalName;
    private String roadNameAddress;

    @OneToMany(mappedBy = "hospital")
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();

    public static HospitalResponse of(Hospital hospital) {
        List<ReviewResponse> converted = hospital.getReviews().stream().map(review -> Review.of(review)).collect(Collectors.toList());
        return HospitalResponse.builder()
                .id(hospital.getId())
                .hospitalName(hospital.getHospitalName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .reviews(converted)
                .build();
    }
}
