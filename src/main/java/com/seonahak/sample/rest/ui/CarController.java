package com.seonahak.sample.rest.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seonahak.sample.rest.model.Car;
import com.seonahak.sample.serivce.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	private CarService carSerivce;
	
	@GetMapping("")
	public List<Car> getAllCars(){
		return carSerivce.getCar();
	}
	
	@GetMapping("/{carId}")
	public Car getCarByUserId(@PathVariable int carId) {
		return carSerivce.getCarById(carId);
	}
	
	@PostMapping("")
	public void insertCar(@RequestBody Car car) {
		carSerivce.insertCar(car);
	}

	@PutMapping("")
	public void modifyCar(@RequestBody Car car) {
		carSerivce.updateCar(car);
	}
	
	@DeleteMapping("/{carId}")
	public void deleteCar(@PathVariable int carId) {
		carSerivce.deleteCar(carId);
	}
}
