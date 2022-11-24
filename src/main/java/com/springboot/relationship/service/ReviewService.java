package com.springboot.relationship.service;

import com.springboot.relationship.domain.dto.ReviewResponse;
import com.springboot.relationship.domain.entity.Review;
import com.springboot.relationship.repository.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public String selectAllReviews(Integer id) {
        List<Review> reviews = reviewRepository.findByHospital_Id(id);
        List<ReviewResponse> reviewResponses = reviews.stream().map(review -> Review.of(review)).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        sb.append("reviews: [");
        for (ReviewResponse reviewResponse : reviewResponses) {
            sb.append(reviewResponse.getTitle());
            counter++;
            if (counter < reviewResponses.size()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
