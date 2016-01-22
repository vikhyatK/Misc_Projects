package com.springdao.mytravel.constant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConstant {
	private static Map<String, String> availableDestinations;
	private static Set<String> availableFlights;
	private static Properties emails;
	
	@Bean(name="availableDestinations")
	public Map<String, String> getAvailableDestinations(){
		if(availableDestinations == null){
		availableDestinations = new HashMap<String, String>();
		availableDestinations.put("MUM", "Mumbai");
		availableDestinations.put("NY", "New York");
		}
		return availableDestinations;
	}
	
	@Bean(name="availableFlights")
	public Set<String> getAvailableFlights(){
		if(availableFlights == null){
			availableFlights = new HashSet<String>();
			availableFlights.add("320");
			availableFlights.add("455");
		}
		return availableFlights;
	}
	
    @Bean(name="emails")
	public Properties getEmails(){
    	if(emails == null){
    	emails = new Properties();
    	emails.setProperty("sales", "sales@example.com");
    	emails.setProperty("admin", "admin@example.com");
    	}
		return emails;
	}

}
