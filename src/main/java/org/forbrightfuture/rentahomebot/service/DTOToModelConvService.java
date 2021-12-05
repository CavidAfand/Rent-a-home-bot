package org.forbrightfuture.rentahomebot.service;

import org.forbrightfuture.rentahomebot.dto.HomeDTO;
import org.forbrightfuture.rentahomebot.entity.City;
import org.forbrightfuture.rentahomebot.entity.Home;

import java.util.List;

public interface DTOToModelConvService {

    Home getHome(HomeDTO homeDTO, List<City> cityList);

}
