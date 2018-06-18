package com.perficient.training.cities.cities;

import com.perficient.training.cities.cities.controller.CityController;
import com.perficient.training.cities.cities.domain.City;
import com.perficient.training.cities.cities.repository.CityRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CityControllerTest {

    private CityRepository cityRepository;
    private CityController cityController;
    private Page<City> inputCity;
    private  City testcity1;
    private  City testcity2;


    @Before
    public void setupMock(){
        cityRepository=mock(CityRepository.class);
        cityController=new CityController(cityRepository);
        testcity1= new City(  1L,"90001","CA","Los Angeles","Los Angeles",22.22,33.33);
        testcity2= new City(  1L,"90002","CA","Los Angeles","Los Angeles",22.22,33.33);

    }

    @Test
    public void whenSave_expectSuccess(){
        when(cityRepository.save(testcity1)).thenReturn(testcity1);

        assertThat(cityController.save(testcity1).getCityName()).isEqualTo(testcity1.getCityName());
        assertThat(cityController.save(testcity1).getPostalCode()).isEqualTo(testcity1.getPostalCode());
        assertThat(cityController.save(testcity1).getLatitude()).isEqualTo(testcity1.getLatitude());
    }


    @Test
    public void whenFindById_expectFindById(){
        when(cityRepository.findById(1L)).thenReturn(testcity1);

        assertThat(cityController.findById(1L).getCityName()).isEqualTo(testcity1.getCityName());
        assertThat(cityController.findById(1L).getPostalCode()).isEqualTo(testcity1.getPostalCode());
        assertThat(cityController.findById(1L).getLatitude()).isEqualTo(testcity1.getLatitude());
    }


    @Test
    public void whenUpdate_expectCity(){
        when(cityRepository.save(testcity1)).thenReturn(testcity1);
        when(cityController.update(1L,testcity2)).thenReturn(testcity2);
        when(cityRepository.findById(1L)).thenReturn(testcity2);
        assertThat(cityController.findById(1L).getPostalCode()).isEqualTo(testcity2.getPostalCode());
    }


    @Test
    public void whenDelete_expectDeleted(){
        when(cityRepository.save(testcity1)).thenReturn(testcity1);
        when(cityRepository.findById(1L)).thenReturn(testcity1);
        doNothing().when(cityRepository).delete(String.valueOf(1L));
        when(cityRepository.findById(1L)).thenReturn(null);
    }

}
