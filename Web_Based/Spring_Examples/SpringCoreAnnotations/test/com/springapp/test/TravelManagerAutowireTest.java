package com.springapp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springcore.mytravel.manager.TravelManager;

@ContextConfiguration(locations = {"classpath:/applicationContextAutowire.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TravelManagerAutowireTest {
	@Autowired
	TravelManager travelManager;
		
	@Test
	public void testTravelManager(){
		travelManager.bookFlight();
		travelManager.bookCab();
		travelManager.bookHotel();
	}

}
