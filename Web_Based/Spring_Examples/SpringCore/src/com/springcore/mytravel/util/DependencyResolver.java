package com.springcore.mytravel.util;

import org.springframework.beans.factory.InitializingBean;

import com.springcore.mytravel.manager.CabinCrewManager;
import com.springcore.mytravel.manager.FlightManager;

public class DependencyResolver implements InitializingBean {

	FlightManager flightManager;
	CabinCrewManager cabinCrewManager;

	public DependencyResolver(FlightManager flightManager,
			CabinCrewManager cabinCrewManager) {
		this.flightManager = flightManager;
		this.cabinCrewManager = cabinCrewManager;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (flightManager != null && cabinCrewManager != null) {
			flightManager.setCabinCrewManager(cabinCrewManager);
		}
	}

}
