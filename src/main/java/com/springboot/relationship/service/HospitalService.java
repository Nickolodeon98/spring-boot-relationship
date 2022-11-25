package com.springboot.relationship.service;

import com.springboot.relationship.domain.dto.HospitalRequest;
import com.springboot.relationship.domain.dto.HospitalResponse;
import com.springboot.relationship.domain.dto.ReviewResponse;
import com.springboot.relationship.domain.entity.Hospital;
import com.springboot.relationship.domain.entity.Review;
import com.springboot.relationship.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalResponse addNewHospital(HospitalRequest hospitalRequest) {
        Hospital savedHospital = hospitalRepository.save(hospitalRequest.toEntity());
        return Hospital.of(savedHospital);
    }

    public List<HospitalResponse> selectAllHospitals() {
        List<Hospital> foundHospitals = hospitalRepository.findAll();
        return foundHospitals.stream().map(Hospital::of).collect(Collectors.toList());
    }
    public HospitalResponse getHospitalInfo(Integer id) {
        Optional<Hospital> foundHospital = hospitalRepository.findById(id);
        Hospital hospital = foundHospital.orElseThrow(()->new RuntimeException());

        List<ReviewResponse> converted =  hospital.getReviews().stream().map(review -> Review.of(review)).collect(Collectors.toList());

        return new HospitalResponse(hospital.getId(), hospital.getHospitalName(), hospital.getRoadNameAddress(), converted);
    }
}
