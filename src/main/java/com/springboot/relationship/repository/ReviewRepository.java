package com.springboot.relationship.repository;

import com.springboot.relationship.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByHospital_Id(Integer id);
}
