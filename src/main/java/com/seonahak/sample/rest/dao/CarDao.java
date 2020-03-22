package com.seonahak.sample.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.seonahak.sample.rest.model.Car;

@Repository
public class CarDao {
	
	public static List<Car> cars;
	
	static {
		cars = new ArrayList<>();
		cars.add(new Car(1, "벤츠"));
		cars.add(new Car(2, "BMW"));
		cars.add(new Car(3, "현대"));
		cars.add(new Car(4, "기아"));
	}

	public List<Car> getCar() {
		System.out.println("자동차 전체 조회");
		return cars;
	}

	public Car getCarById(int carId) {
		System.out.println("자동차 조회");
		return cars.stream().filter(car -> car.getCarId() == carId).findAny().orElse(new Car(0, "no car"));
	}

	public void insertCar(Car car) {
		System.out.println("자동차 등록");
		cars.add(car);
	}

	public void deleteCar(int carId) {
		System.out.println("자동차 삭제");
		cars.removeIf(car -> car.getCarId() == carId);
	}

	public void updateCar(Car car) {
		System.out.println("자동차 수정");
		cars.stream().filter(item -> item.getCarId() == car.getCarId()).findAny().orElse(new Car(0, "no car")).setCarName(car.getCarName());
	}
}
