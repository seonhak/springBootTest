package com.seonahak.sample.rest.serivce.impl;

import org.springframework.stereotype.Service;

@Service
public class TestJunit5Service {
	
	public Integer add(Integer value1, Integer value2) {
		return value1 + value2;
	}
	
	public Integer multiply(Integer value1, Integer value2) {
		return value1 * value2;
	}
	
	public String greetAliens(String alienRace) {
		return "Hello fellow aliens with race: " + alienRace;
	}
}
