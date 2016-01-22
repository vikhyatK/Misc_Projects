package com.hibernateapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernateapp.manager.TravelManager;

/**
 * @author gurunathj
 * 
 */
public class TravelManagerTest {

	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextDatasource.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextDeclarative.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAnnotation.xml");
		TravelManager travelManager = context.getBean("travelManager", TravelManager.class);
		travelManager.bookFlight("Gurunath Josh");
	}

}
