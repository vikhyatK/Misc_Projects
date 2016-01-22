package com.springdao.mytravel.constant;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.springdao.mytravel.model.Company;

@Configuration
@DependsOn("appConstant")
public class AirlineInfo {
	private static AirlineInfo airlineInfo = new AirlineInfo();

	@Resource(name="availableFlights")
	private Set<String> availableFlights;
	@Resource(name="availableDestinations")
	private Map<String, String> availableDistinations;
	@Resource(name="emails")
	private Properties emails;
	
	private Company company = new Company("Air India");
	
	public AirlineInfo(){
		
	}
	
	@Bean
	public static AirlineInfo getInstance(){
		return airlineInfo;
	}
	
	@Bean
	public Company getCompany(){
		return company;
	}

	public Properties getEmails() {
		return emails;
	}
	
	public Set<String> getAvailableFlights() {
		return availableFlights;
	}

	public Map<String, String> getAvailableDistinations() {
		return availableDistinations;
	}

}
