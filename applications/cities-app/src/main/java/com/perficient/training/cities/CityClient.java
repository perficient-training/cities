package com.perficient.training.cities;

import java.util.ArrayList;
import java.util.List;

public class CityClient {
    private final List<CityInfo> cities = new ArrayList<>();

    public void addCity(CityInfo cityInfo) {
        // TODO: replace with reset template calls to the add city microservice
        cities.add(cityInfo);
    }

    public List<CityInfo> getCities() {
        // TODO: replace with reset template calls to the get all citites microservice
        return cities;
    }

}
