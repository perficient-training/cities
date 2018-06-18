package com.perficient.training.cities.cities.repository;

import com.perficient.training.cities.cities.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends PagingAndSortingRepository<City,String> {
    Page<City> findByCityName(String cityName, Pageable pageable);
    City findById(long id);
}
