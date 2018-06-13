package com.perficient.training.cities.cities.controller;


import com.perficient.training.cities.cities.domain.City;
import com.perficient.training.cities.cities.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;


    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_SIZE = 10;


    @PostMapping("/cities")
    @ResponseStatus(HttpStatus.CREATED)
    public City save(@RequestBody City city){
        return this.cityRepository.save(city);
    }


    @GetMapping("/cities")
    @ResponseStatus(HttpStatus.OK)
    public Page<City> findAll(
            @PageableDefault(page = DEFAULT_PAGE_NUMBER, size = DEFAULT_PAGE_SIZE) Pageable pageable){
        return this.cityRepository.findAll(pageable);
    }

    @GetMapping("/cities/{cityName}")
    @ResponseStatus(HttpStatus.OK)
    public City find(@PathVariable String cityName){
        return this.cityRepository.findByCityName(cityName);
    }



    @PutMapping("/cities/{id}")
    @ResponseStatus(HttpStatus.OK)
    public City update(@PathVariable long id, @RequestBody City city){

        City updateCity = cityRepository.findById(id);
        updateCity.setPostalCode(city.getPostalCode());
        updateCity.setStateCode((city.getStateCode()));
        updateCity.setCityName(city.getCityName());
        updateCity.setCountyName(city.getCountyName());
        updateCity.setLattitude(city.getLattitude());
        updateCity.setLongitude(city.getLongitude());

        City updatedCity = cityRepository.save(updateCity);

        return updatedCity;
    }

    @DeleteMapping("/cities/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id){
        cityRepository.delete(cityRepository.findById(id));
    }


}
