package com.cars.services;

import com.cars.entities.CarEntity;
import com.cars.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    // Método para buscar todos os carros com paginação
    public Page<CarEntity> getAllCars(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return carRepository.findAll(pageable);
    }

    // Método para salvar um novo carro
    public CarEntity createCar(CarEntity carEntity) {
        return carRepository.save(carEntity);
    }
}
