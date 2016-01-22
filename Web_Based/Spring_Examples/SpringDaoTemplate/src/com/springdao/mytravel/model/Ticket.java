package com.springdao.mytravel.model;

import java.util.Date;

public class Ticket {
	private long ticketId;
	private String flightNumber;
	private String passengerName;
	private Date time;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	
	
	public String toString(){
		   StringBuilder stringBuilder = new StringBuilder();
		   stringBuilder.append("Id: ").append(ticketId).append("\n");
		   stringBuilder.append("Date Time: ").append(time).append("\n");
		   stringBuilder.append("Passenger Name: ").append(passengerName).append("\n");
		   stringBuilder.append("Flight Number: ").append(flightNumber);
		   return stringBuilder.toString();
	}

}
