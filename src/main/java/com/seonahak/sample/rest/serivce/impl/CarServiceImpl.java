package com.seonahak.sample.rest.serivce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seonahak.sample.rest.dao.CarDao;
import com.seonahak.sample.rest.model.Car;
import com.seonahak.sample.rest.serivce.CarService;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarDao carDao;

	@Override
	public List<Car> getCar() {
		return carDao.getCar();
	}

	@Override
	public Car getCarById(int carId) {
		return carDao.getCarById(carId);
	}

	@Override
	public void insertCar(Car car) {
		carDao.insertCar(car);
	}

	@Override
	public void deleteCar(int carId) {
		carDao.deleteCar(carId);
	}

	@Override
	public void updateCar(Car car) {
		carDao.updateCar(car);
	}

}
