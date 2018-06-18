package com.perficient.training.cities.cities;


import com.perficient.training.cities.cities.domain.City;
import com.perficient.training.cities.cities.repository.CityRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CityRepositoryTest {

    @Autowired
    private CityRepository cityRepository;

    City testcity= new City(1L,  "90001","CA","Los Angeles","Los Angeles",22.22,33.33);

    @Before
    public void setup() {
        this.cityRepository.save(testcity);
    }

    @Test
    public void  whenfindByCityName_expectCityName(){
        assertThat(this.cityRepository.findByCityName("Los Angeles",new PageRequest(0,1)).getContent().get(0).getCityName()).isEqualTo("Los Angeles");
    }

    @Test
    public void  whenfindByCityId_expectCity(){
        assertThat(this.cityRepository.findById(1L).getCityName()).isEqualTo(testcity.getCityName());
        assertThat(this.cityRepository.findById(1L).getCountyName()).isEqualTo(testcity.getCountyName());
        assertThat(this.cityRepository.findById(1L).getLatitude()).isEqualTo(testcity.getLatitude());
        assertThat(this.cityRepository.findById(1L).getLongitude()).isEqualTo(testcity.getLongitude());
        assertThat(this.cityRepository.findById(1L).getPostalCode()).isEqualTo(testcity.getPostalCode());
        assertThat(this.cityRepository.findById(1L).getStateCode()).isEqualTo(testcity.getStateCode());
    }
}
