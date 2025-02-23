package com.cars.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private String modelYear;

}
