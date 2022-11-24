package com.springboot.relationship.domain.entity;

import com.springboot.relationship.domain.dto.HospitalResponse;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
        List<Review> toConvert = hospital.getReviews();
//        List<String> converted = new ArrayList<>();
//        for (Review review : toConvert) {
//            converted.add(review.getTitle());
//        }
        return HospitalResponse.builder()
                .roadNameAddress(hospital.getRoadNameAddress())
                .reviews(hospital.getReviews())
                .build();
    }
}
