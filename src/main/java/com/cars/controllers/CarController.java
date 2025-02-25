package com.cars.controllers;

import com.cars.dto.CarDTO;
import com.cars.entities.CarEntity;
import com.cars.mappers.CarMapper;
import com.cars.model.CarModel;
import com.cars.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private final CarMapper carMapper;

    @GetMapping
    public ResponseEntity<Page<CarEntity>> getAllCars(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(carService.getAllCars(page, size));
    }

    @PostMapping
    public ResponseEntity<Page<CarDTO>> addCar(@RequestBody CarModel carModel) {
        carService.addCar(carModel);
        Page<CarEntity> cars = carService.getAllCars(0, 10);

        Function<CarEntity, CarDTO> mapper = entity -> {
            CarDTO carDTO = new CarDTO();
            carDTO.setId(entity.getId());
            carDTO.setBrand(entity.getBrand());
            carDTO.setModel(entity.getModel());
            carDTO.setModelYear(entity.getModelYear());
            return carDTO;
        };

        return ResponseEntity.ok(carMapper.toPage(cars, mapper));
    }

}
