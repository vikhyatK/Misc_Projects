package com.springapp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.mytravel.constant.AirlineInfo;
import com.springcore.mytravel.model.Company;


public class AirlineInfoTest {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext(
		"applicationContextAirlineInfo.xml");
		AirlineInfo airlineInfo = context.getBean("airlineInfo", AirlineInfo.class);
		//AirlineInfo airlineInfo = AirlineInfo.getInstance();

		System.out.println(airlineInfo.getAvailableDistinations());
		System.out.println(airlineInfo.getAvailableFlights());
		System.out.println(airlineInfo.getEmails());

		Company company = context.getBean("company", Company.class);
		System.out.println(company);
	}
}
