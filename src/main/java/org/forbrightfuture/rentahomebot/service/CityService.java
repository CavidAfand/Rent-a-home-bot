package org.forbrightfuture.rentahomebot.service;

import org.forbrightfuture.rentahomebot.entity.City;

import java.io.IOException;
import java.util.List;

public interface CityService {

    void updateCities() throws IOException;

    List<City> getCityList();

    City getCityByCityName(String cityName);

}
