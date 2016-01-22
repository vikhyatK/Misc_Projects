package com.aopapp.manager;

import org.springframework.stereotype.Component;

import com.aopapp.model.Flight;

@Component
public class FlightManager {
	Flight flight;

	public void assignFlight(){
		flight = new Flight();
	}

	
	public void boarding(){
		
	}
	
	public void boardPassengers(){
		
	}

	public void start(){
		System.out.println("Flight started");
	}
	
	public void takeOff() throws Exception{
		boolean status = false;
		if(!status){
			System.out.println("Problem in take off.. ");
			throw new Exception("Error in take off..");
		}
		System.out.println("Flight take off successful");
	}
	
	public void landing(){
		System.out.println("Flight landed");
	}
	
	public void unassignFlight(){
		flight = null;
	}

}
