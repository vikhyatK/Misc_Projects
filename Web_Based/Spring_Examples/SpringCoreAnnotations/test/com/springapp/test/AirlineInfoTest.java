package com.springapp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.springcore.mytravel.constant.AirlineInfo;
import com.springcore.mytravel.constant.AppConstant;
import com.springcore.mytravel.model.Company;

//@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
		classes = { AirlineInfo.class, AppConstant.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class AirlineInfoTest {

	@Autowired
	AirlineInfo airlineInfo;
	@Autowired
	Company company;

	@Test
	public void testGetAirlineInfo() {
		System.out.println(airlineInfo.getAvailableDistinations());
		System.out.println(airlineInfo.getAvailableFlights());
		System.out.println(airlineInfo.getEmails());
	}

	public void testGetCompany() {
		System.out.println(company);
	}
}
