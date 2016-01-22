package com.springcore.mytravel.model;

import java.util.Date;
import java.util.List;

public class Hotel {

	private String name;
	private int roomNumber;
	private List<String> customerNames;
	private Date checkInDate;
	private Date checkOutDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public List<String> getCustomerNames() {
		return customerNames;
	}

	public void setCustomerNames(List<String> customerNames) {
		this.customerNames = customerNames;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
}
