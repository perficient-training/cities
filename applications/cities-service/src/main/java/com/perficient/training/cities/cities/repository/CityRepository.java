package com.perficient.training.cities.cities.repository;

import com.perficient.training.cities.cities.domain.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends PagingAndSortingRepository<City,String> {
    City findByCityName(String cityName);
    City findById(long id);
}
