package com.springboot.relationship.controller;

import com.springboot.relationship.domain.dto.HospitalResponse;
import com.springboot.relationship.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospitals")
@Slf4j
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<String> getReviewsForHospital(@PathVariable Integer id) {
        HospitalResponse hospital = hospitalService.getHospitalInfo(id);
//        for (String str : hospital.getReviews()) {
//            log.info(str);
//        }
        String ret = String.format(hospital.getRoadNameAddress() + " " + hospital);
        return ResponseEntity.ok().body(ret);
    }

}
