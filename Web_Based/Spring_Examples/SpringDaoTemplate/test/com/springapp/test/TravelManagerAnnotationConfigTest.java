package com.springapp.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdao.mytravel.manager.TravelManager;

public class TravelManagerAnnotationConfigTest {
	TravelManager travelManager;
	
	@Test
	public void testTravelManager(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.springdao.mytravel.util");
		context.scan("com.springdao.mytravel");
		context.refresh();
		
		travelManager = context.getBean("travelManager", TravelManager.class);
		travelManager.bookFlight("Gurunath Joshi");
		
		//travelManager.cancelFlight(2);
	}

}
