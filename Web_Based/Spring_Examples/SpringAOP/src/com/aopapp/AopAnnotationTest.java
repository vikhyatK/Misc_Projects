package com.aopapp;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopapp.manager.AirIndiaFlightManager;
import com.aopapp.manager.FlightManager;
import com.aopapp.manager.IndigoFlightManager;

public class AopAnnotationTest {
	
	FlightManager flightManager;
	
	@Test
	public void testTravelManager() throws Exception{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.aopapp");
		context.refresh();
		
		System.out.println("***********FlightManager*************");
		flightManager = context.getBean("flightManager", FlightManager.class);
		flightManager.takeOff();
		System.out.println("*************************************");
		
		System.out.println("***********AirIndiaFlightManager*************");
		flightManager = context.getBean("airIndiaFlightManager", AirIndiaFlightManager.class);
		flightManager.takeOff();
		System.out.println("*************************************");
		
		System.out.println("***********IndigoFlightManager*************");
		flightManager = context.getBean("indigoFlightManager", IndigoFlightManager.class);
		flightManager.takeOff();
		System.out.println("*************************************");
	}

}
