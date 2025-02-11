package com.cars.controllers;

import com.cars.entities.CarEntity;
import com.cars.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public ResponseEntity<Page<CarEntity>> getAllCars(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(carService.getAllCars(page, size));
    }

    @PostMapping
    public ResponseEntity<CarEntity> createCar(@RequestBody CarEntity carEntity) {
        CarEntity newCar = carService.createCar(carEntity);
        return ResponseEntity.ok(newCar);
    }
}
