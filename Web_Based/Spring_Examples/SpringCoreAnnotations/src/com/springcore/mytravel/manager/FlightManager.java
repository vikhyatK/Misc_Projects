package com.springcore.mytravel.manager;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springcore.mytravel.model.Flight;

@Component
public class FlightManager {
	CabinCrewManager cabinCrewManager;
	Flight flight;
	@Autowired
	Date currentTime; 

    @PostConstruct
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

	@Autowired
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
	
	@PreDestroy
	public void unassignFlight(){
		flight = null;
	}

}
