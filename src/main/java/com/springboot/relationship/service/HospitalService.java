package com.springboot.relationship.service;

import com.springboot.relationship.domain.dto.HospitalResponse;
import com.springboot.relationship.domain.entity.Hospital;
import com.springboot.relationship.domain.entity.Review;
import com.springboot.relationship.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalResponse getHospitalInfo(Integer id) {
        Optional<Hospital> foundHospital = hospitalRepository.findById(id);
        Hospital hospital = foundHospital.orElse(Hospital.builder().build());
//
//        List<String> list = new ArrayList<>();
//
//        for (Review review : hospital.getReviews()) {
//            list.add(review.getTitle());
//        }
        return new HospitalResponse(hospital.getId(), hospital.getRoadNameAddress(), hospital.getReviews());
    }
}
