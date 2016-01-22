package com.springapp.model;

import java.util.Date;

public interface Ticket {

	long getId();

	void setId(long id);

	Date getDateTime();

	void setDateTime(Date time);

	String getPassengerName();

	void setPassengerName(String passengerName);
	
	String getInfo();
}
