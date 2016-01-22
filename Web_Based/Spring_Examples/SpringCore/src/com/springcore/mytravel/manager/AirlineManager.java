package com.springcore.mytravel.manager;

import com.springcore.mytravel.constant.AirlineInfo;

public class AirlineManager {
	SecuritySystemManager securitySystemManager;
	AirlineInfo airlineInfo;
	
	public AirlineManager(SecuritySystemManager securitySystemManager){
		this.securitySystemManager = securitySystemManager;
	}

	public AirlineInfo getAirlineInfo() {
		return airlineInfo;
	}

	public void setAirlineInfo(AirlineInfo airlineInfo) {
		this.airlineInfo = airlineInfo;
	}

	public void scheduleFlight(){
		
	}
	
	public void getFlightSchedule(){
		
	}
	
	public void performSecuirityCheck(){
		
	}
	
	public void performCheckIn(){
		
	}

}
