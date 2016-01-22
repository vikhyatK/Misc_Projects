package com.aopapp;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aopapp.manager.FlightManager;

/**
 * @author gurunathj
 * 
 */
public class AopTest {

	public static void main(String args[])  {
		//ApplicationContext context = new ClassPathXmlApplicationContext(
		//		"applicationContext.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext(
		//"applicationContext_declarative.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext(
		"applicationContext_annotation.xml");
		FlightManager flightManager = (FlightManager)context.getBean("flightManager");
		try {
			flightManager.takeOff();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
