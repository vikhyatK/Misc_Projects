package com.hibernateapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TICKETS")
public class Ticket {
	@Id
	@Column(name="TICKETID")
	@GeneratedValue(
			strategy=GenerationType.AUTO)
	private long ticketId;
	@Column(name="FLIGHTNUMBER")
	private String flightNumber;
	@Column(name="PASSENGERNAME")
	private String passengerName;
	@Column(name="TIME")
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
