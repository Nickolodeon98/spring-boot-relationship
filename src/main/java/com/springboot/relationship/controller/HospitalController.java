package com.springboot.relationship.controller;

import com.springboot.relationship.domain.dto.HospitalRequest;
import com.springboot.relationship.domain.dto.HospitalResponse;
import com.springboot.relationship.domain.dto.ReviewRequest;
import com.springboot.relationship.domain.dto.ReviewResponse;
import com.springboot.relationship.domain.entity.Review;
import com.springboot.relationship.service.HospitalService;
import com.springboot.relationship.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @PostMapping("/new")
    public ResponseEntity<HospitalResponse> addNewHospital(@RequestBody HospitalRequest hospitalRequest) {
        HospitalResponse savedHospital = hospitalService.addNewHospital(hospitalRequest);
        log.info(savedHospital.getHospitalName());
        return ResponseEntity.ok().body(savedHospital);
    }

    @GetMapping("/all")
    public ResponseEntity<List<HospitalResponse>> findAllHospitals() {
        List<HospitalResponse> foundHospitals = hospitalService.selectAllHospitals();
        return ResponseEntity.ok().body(foundHospitals);
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<ReviewResponse>> getReviewsForHospital(@PathVariable Integer id) {
        HospitalResponse hospital = hospitalService.getHospitalInfo(id);
        return ResponseEntity.ok().body(hospital.getReviews());
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

    @GetMapping("/{id}/reviews/all")
    public ResponseEntity<String> showEveryReview(@PathVariable Integer id) {
        String response = reviewService.selectAllReviews(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}/info/reviews")
    public ResponseEntity<String> showHospitalAndReview(@PathVariable Integer id) {
        HospitalResponse hospitalResponse = hospitalService.getHospitalInfo(id);
        String reviews = reviewService.selectAllReviews(id);
        String response = String.format("hospitalName: " + hospitalResponse.getHospitalName()+ " " + reviews);
        return ResponseEntity.ok().body(response);
    }
}
