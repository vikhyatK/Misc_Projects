package com.springapp.model;

import java.util.Date;

public class TrainTicket implements Ticket{
	long id;
	Date dateTime;
	String passengerName;
	long trainNumber;

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

	public long getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(long trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getInfo(){
	   StringBuilder stringBuilder = new StringBuilder();
	   stringBuilder.append("Id: ").append(id);
	   stringBuilder.append("Date Time: ").append(dateTime);
	   stringBuilder.append("Passenger Name: ").append(passengerName);
	   stringBuilder.append("Flight Number: ").append(trainNumber);
	   return stringBuilder.toString();
	}
}
