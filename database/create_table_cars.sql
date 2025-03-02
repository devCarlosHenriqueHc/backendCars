CREATE DATABASE CarsDB;
USE CarsDB;

CREATE TABLE Cars (
    id INT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(100) NOT NULL,
    model VARCHAR(50) NOT NULL,
    model_year INT NOT NULL
);

DELIMITER //

CREATE PROCEDURE InsertCars()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= 1000 DO
        INSERT INTO cars (brand, model, model_year)
        VALUES (
            CONCAT('Brand', i),
            CONCAT('Model', (i MOD 10 + 1)),
            (2000 + (i MOD 23))
        );
        SET i = i + 1;
    END WHILE;
END //

DELIMITER ;

-- Call the procedure to insert the data
CALL InsertCars();

DROP PROCEDURE IF EXISTS InsertCars;