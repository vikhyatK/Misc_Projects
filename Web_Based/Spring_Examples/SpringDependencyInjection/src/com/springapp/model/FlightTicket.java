package com.springapp.model;

import java.util.Date;

public class FlightTicket implements Ticket{
	long id;
	Date dateTime;
	String passengerName;
	long flightNumber;

	public FlightTicket() {
		
	}

	public FlightTicket(long id, Date dateTime, String passengerName,
			long flightNumber) {
		this.id = id;
		this.dateTime = dateTime;
		this.passengerName = passengerName;
		this.flightNumber = flightNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getInfo(){
		   StringBuilder stringBuilder = new StringBuilder();
		   stringBuilder.append("Id: ").append(id).append("\n");
		   stringBuilder.append("Date Time: ").append(dateTime).append("\n");
		   stringBuilder.append("Passenger Name: ").append(passengerName).append("\n");
		   stringBuilder.append("Flight Number: ").append(flightNumber);
		   return stringBuilder.toString();
	}
}
