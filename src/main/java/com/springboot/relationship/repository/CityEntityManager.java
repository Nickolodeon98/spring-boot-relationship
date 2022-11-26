package com.springboot.relationship.repository;

import com.springboot.relationship.domain.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityEntityManager extends JpaRepository<City, Long> {

}
