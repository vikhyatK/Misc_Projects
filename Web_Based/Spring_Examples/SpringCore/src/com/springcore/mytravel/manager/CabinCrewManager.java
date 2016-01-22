package com.springcore.mytravel.manager;

public class CabinCrewManager {
	FlightManager flightManager;
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
