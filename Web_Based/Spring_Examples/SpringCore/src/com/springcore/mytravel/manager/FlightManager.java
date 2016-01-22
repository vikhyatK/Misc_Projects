package com.springcore.mytravel.manager;

import java.util.Date;

import com.springcore.mytravel.model.Flight;

public class FlightManager {
	CabinCrewManager cabinCrewManager;
	Flight flight;
	Date currentTime; 


	public void assignFlight(){
		flight = new Flight();
	}

	public Date getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}
	
	public CabinCrewManager getCabinCrewManager() {
		return cabinCrewManager;
	}

	public void setCabinCrewManager(CabinCrewManager cabinCrewManager) {
		this.cabinCrewManager = cabinCrewManager;
	}
	
	public void boardCabinCrew(){
		
	}
	
	public void boardPassengers(){
		
	}

	public void start(){
		
	}
	
	public void takeOff(){
		
	}
	
	public void landing(){
		
	}
	
	public void unassignFlight(){
		flight = null;
	}

}
