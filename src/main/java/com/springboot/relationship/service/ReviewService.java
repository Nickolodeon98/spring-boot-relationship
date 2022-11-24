package com.springboot.relationship.service;

import com.springboot.relationship.domain.dto.ReviewResponse;
import com.springboot.relationship.domain.entity.Review;
import com.springboot.relationship.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review registerReview(Review review) {
        return reviewRepository.save(review);
    }

    public ReviewResponse selectSingleReview(Integer id) {
        Optional<Review> foundReview = reviewRepository.findById(id);
        Review review = foundReview.orElse(Review.builder().build());
        return Review.of(review);
    }
}
