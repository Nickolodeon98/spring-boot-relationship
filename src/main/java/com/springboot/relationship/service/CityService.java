package com.springboot.relationship.service;

import com.springboot.relationship.domain.entity.City;
import com.springboot.relationship.repository.CityEntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityEntityManager cityEntityManager;

    public List<City> findAllCities() {
        return cityEntityManager.findAll();
    }
}
