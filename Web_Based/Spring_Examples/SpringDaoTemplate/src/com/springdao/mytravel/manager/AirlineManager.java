package com.springdao.mytravel.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.springdao.mytravel.constant.AirlineInfo;

@Component
@Lazy(value=true)
@DependsOn(value="flightManager")
public class AirlineManager {
	@Autowired(required=false)
	SecuritySystemManager securitySystemManager;
	AirlineInfo airlineInfo;
	
	@Autowired
	public AirlineManager(AirlineInfo airlineInfo){
		this.airlineInfo = airlineInfo;
	}

	public SecuritySystemManager getSecuritySystemManager() {
		return securitySystemManager;
	}

	public void setSecuritySystemManager(SecuritySystemManager securitySystemManager) {
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
