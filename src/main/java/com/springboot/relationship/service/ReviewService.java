package com.springboot.relationship.service;

import com.springboot.relationship.domain.entity.Review;
import com.springboot.relationship.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review registerReview(Review review) {
        return reviewRepository.save(review);
    }
}
