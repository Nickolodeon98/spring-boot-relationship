package com.springboot.relationship.domain.entity;

import com.springboot.relationship.domain.dto.HospitalResponse;
import com.springboot.relationship.domain.dto.ReviewResponse;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name = "review")
@ToString
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String patientName;
    private String contents;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    public void setHospital(HospitalResponse hospitalResponse) {
        this.hospital = hospitalResponse.toEntity();
    }

    public static ReviewResponse of(Review review) {
        return ReviewResponse.builder()
                .contents(review.getContents())
                .patientName(review.getPatientName())
                .title(review.getTitle())
                .hospitalName(review.getHospital().getHospitalName())
                .build();
    }
}
