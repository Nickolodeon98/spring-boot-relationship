package com.springboot.relationship.controller;

import com.springboot.relationship.domain.dto.HospitalResponse;
import com.springboot.relationship.domain.dto.ReviewRequest;
import com.springboot.relationship.domain.dto.ReviewResponse;
import com.springboot.relationship.domain.entity.Hospital;
import com.springboot.relationship.domain.entity.Review;
import com.springboot.relationship.service.HospitalService;
import com.springboot.relationship.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospitals")
@Slf4j
public class HospitalController {

    private final HospitalService hospitalService;
    private final ReviewService reviewService;

    public HospitalController(HospitalService hospitalService, ReviewService reviewService) {
        this.hospitalService = hospitalService;
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<String> getReviewsForHospital(@PathVariable Integer id) {
        HospitalResponse hospital = hospitalService.getHospitalInfo(id);
//        for (String str : hospital.getReviews()) {
//            log.info(str);
//        }
        String ret = String.format(hospital.getRoadNameAddress() + " " + hospital.getReviews());
        return ResponseEntity.ok().body(ret);
    }

    @PostMapping("/{id}/feedback")
    public ResponseEntity<ReviewResponse> addReviewForHospital(@PathVariable Integer id, @RequestBody ReviewRequest reviewRequest) {
        Review review = reviewRequest.toEntity();
        review.setHospital(hospitalService.getHospitalInfo(id));
        ReviewResponse reviewResponse = Review.of(reviewService.registerReview(review));
        return ResponseEntity.ok().body(reviewResponse);
    }

    @GetMapping("/review/{id}")
    public ResponseEntity<ReviewResponse> showAReview(@PathVariable Integer id) {
        return ResponseEntity.ok().body(reviewService.selectSingleReview(id));
    }


}
