package com.cars.mappers;

import com.cars.dto.CarDTO;
import com.cars.entities.CarEntity;
import com.cars.model.CarModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CarMapper {

    public CarEntity toEntity(CarModel carModel) {
        CarEntity carEntity = new CarEntity();
        carEntity.setBrand(carModel.getBrand());
        carEntity.setModel(carModel.getModel());
        carEntity.setModelYear(carModel.getModelYear());
        return carEntity;
    }

    public CarDTO toDTO(CarEntity carEntity){
        CarDTO carDTO = new CarDTO();
        carDTO.setId(carEntity.getId());
        carDTO.setBrand(carEntity.getBrand());
        carDTO.setModelYear(carEntity.getModelYear());
        carDTO.setModel(carEntity.getModel());
        return carDTO;
    }

    public List<CarDTO> toListDTO(List<CarEntity> cars) {
        return cars.stream().map(this::toDTO).toList();
    }

    public <T, U> Page<U> toPage(Page<T> sourcePage, Function<T, U> mapper) {
        List<U> dtoList = sourcePage.getContent().stream()
                .map(mapper)
                .collect(Collectors.toList());

        return new PageImpl<>(
                dtoList,
                sourcePage.getPageable(),
                sourcePage.getTotalElements()
        );
    }

}
