package com.springapp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.mytravel.manager.TravelManager;

public class TravelManagerTest {
	
	public static void main(String[] args){
		//ApplicationContext context = new ClassPathXmlApplicationContext(
		//"applicationContext.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext(
		"applicationContextAutowire.xml");
		TravelManager travelManager = context.getBean("travelManager", TravelManager.class);
		travelManager.bookFlight();
		travelManager.bookCab();
		travelManager.bookHotel();
	}

}
