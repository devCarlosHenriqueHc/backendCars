package com.cars.services;

import com.cars.entities.CarEntity;
import com.cars.mappers.CarMapper;
import com.cars.model.CarModel;
import com.cars.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    // Método para buscar todos os carros com paginação
    public Page<CarEntity> getAllCars(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return carRepository.findAll(pageable);
    }

    public void addCar(CarModel carModel) {
        CarEntity carEntity = carMapper.toEntity(carModel);
        carRepository.save(carEntity);
    }

}
