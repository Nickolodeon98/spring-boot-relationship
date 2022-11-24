package com.springboot.relationship.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name = "review")
@ToString
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
}
