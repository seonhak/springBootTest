package com.seonahak.sample.rest.serivce.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS) 
//참고 URL : https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/TestInstance.html
//@TestInstance를 선언하지 않으면 기본적으로 PER_METHOD 로 설정됨
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class TestJunit5ServiceTest {

	String importantValue = "Remember to fuel the ship";
	
	@Autowired
	TestJunit5Service testJunit5ServiceTest;
	
	@RepeatedTest(3)
	@DisplayName("Add numbers. This is need for navigation.")
	//@Test
	@Tag("fuel")
	final void testAdd() {
		Integer add = testJunit5ServiceTest.add(4, 8);
		assertEquals(12, add);
		assertEquals("Remember to fuel the ship",  importantValue);
		importantValue = "altered in add mothod";
	}

	@Test
	@DisplayName("Multiply first value with second value. Is used to calc. fuel left.")
	@Tag("fuel")
	final void testMultiply() {
		assertEquals(20, testJunit5ServiceTest.multiply(2, 10));
		assertEquals("Remember to fuel the ship",  importantValue);
		importantValue = "altered mulitpy ";
	}

	@Test
	@DisplayName("Greet the aliens so they dont get offended.")
	@Tags({@Tag("collaboration"), @Tag("fuel")})
	final void testGreetAliens() {
		assertEquals("Hello fellow aliens with race: wookies", testJunit5ServiceTest.greetAliens("wookies"));
		assertEquals("Remember to fuel the ship",  importantValue);
		importantValue = "altered greet aliens ";
	}
	
	@Test
	void newmethod() {
		assertEquals(2, 2);
	}
	
	@Nested
	class Crew{
		@Test
		void testThePilot() {
			
		}
		
		@Test
		void checkTheNavigator() {
			
		}
	}
}
