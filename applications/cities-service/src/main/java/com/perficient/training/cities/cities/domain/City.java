package com.perficient.training.cities.cities.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="city")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class City {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String postalCode;

    private String stateCode;

    @Column(name = "name")
    private String cityName;

    @Column(name = "county")
    private String countyName;

    private double latitude;

    private double longitude;


    public City(String postalCode, String stateCode, String cityName, String countyName, double latitude, double longitude) {
        this.postalCode = postalCode;
        this.stateCode = stateCode;
        this.cityName = cityName;
        this.countyName = countyName;
        this.latitude = latitude;
        this.longitude = longitude;
    }



}
