package org.forbrightfuture.rentahomebot.repository;

import org.forbrightfuture.rentahomebot.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    @Query("select count(c) from City c")
    long countCities();

    @Modifying
    @Query("update City c set c.active = false")
    void deactiveCities();

    City getCityByDescription(String description);

    @Query("select c from City c where c.active = true")
    List<City> getCities();

}
