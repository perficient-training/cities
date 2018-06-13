package com.perficient.training.cities;

import java.util.Objects;

public class CityInfo {
    private String name;
    private String county;
    private String stateCode;
    private String postalCode;
    private float latitude;
    private float longitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityInfo cityInfo = (CityInfo) o;
        return Float.compare(cityInfo.latitude, latitude) == 0 &&
                Float.compare(cityInfo.longitude, longitude) == 0 &&
                Objects.equals(name, cityInfo.name) &&
                Objects.equals(county, cityInfo.county) &&
                Objects.equals(stateCode, cityInfo.stateCode) &&
                Objects.equals(postalCode, cityInfo.postalCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, county, stateCode, postalCode, latitude, longitude);
    }
}
