package com.springcore.mytravel.dao;

import com.springcore.mytravel.model.Hotel;

public class HotelDao extends GenericDao{
	
	public Hotel getHotelBooking(long bookingId){
		Hotel hotel = null;
		System.out.println("Retrieved hotel booking!");
		return hotel;
	}
	
	public void saveHotelBooking(Hotel hotel){
		System.out.println("Hotel booked!");
	}
	
	public void cancelHotelBooking(long bookingId){
		System.out.println("Hotel booking cancelled!");
	}

}
