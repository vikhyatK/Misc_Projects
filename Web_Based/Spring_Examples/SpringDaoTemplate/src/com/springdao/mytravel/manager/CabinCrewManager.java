package com.springdao.mytravel.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CabinCrewManager {
	@Autowired
	FlightManager flightManager;
	@Autowired
	AirlineManager airlineManager;

	public FlightManager getFlightManager() {
		return flightManager;
	}

	public void setFlightManager(FlightManager flightManager) {
		this.flightManager = flightManager;
	}
	
	public void checkFlightSchedule(){
		airlineManager.getFlightSchedule();
	}
	
	public void boardFlight(){
		flightManager.boardCabinCrew();
	}
	
	public void operateFlight(){
		flightManager.boardPassengers();
		flightManager.start();
		flightManager.takeOff();
		flightManager.landing();
	}
	
}
