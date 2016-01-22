package com.springcore.mytravel.constant;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.springcore.mytravel.model.Company;

public class AirlineInfo {
	private static AirlineInfo airlineInfo = new AirlineInfo();

	private Set<String> availableFlights;
	private Map<String, String> availableDistinations;
	private Properties emails;
	private Company company = new Company("Air India");
	
	private AirlineInfo(){
		
	}
	
	public static AirlineInfo getInstance(){
		return airlineInfo;
	}
	
	public Company getCompany(){
		return company;
	}

	public Properties getEmails() {
		return emails;
	}

	public void setEmails(Properties emails) {
		this.emails = emails;
	}

	public Set<String> getAvailableFlights() {
		return availableFlights;
	}

	public void setAvailableFlights(Set<String> availableFlights) {
		this.availableFlights = availableFlights;
	}

	public Map<String, String> getAvailableDistinations() {
		return availableDistinations;
	}

	public void setAvailableDistinations(
			Map<String, String> availableDistinations) {
		this.availableDistinations = availableDistinations;
	}

}
