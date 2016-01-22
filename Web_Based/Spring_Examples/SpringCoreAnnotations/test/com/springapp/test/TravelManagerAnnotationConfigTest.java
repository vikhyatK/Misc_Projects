package com.springapp.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcore.mytravel.manager.TravelManager;

public class TravelManagerAnnotationConfigTest {
	TravelManager travelManager;
	
	@Test
	public void testTravelManager(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.springcore.mytravel");
		context.refresh();
		travelManager = context.getBean("travelManager", TravelManager.class);
		travelManager.bookFlight();
		travelManager.bookCab();
		travelManager.bookHotel();
	}

}
