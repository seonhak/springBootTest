package com.seonahak.sample.rest.serivce;

import java.util.List;

import com.seonahak.sample.rest.model.Car;

public interface CarService {

	List<Car> getCar();

	Car getCarById(int carId);

	void insertCar(Car car);

	void deleteCar(int carId);

	void updateCar(Car car);
}
