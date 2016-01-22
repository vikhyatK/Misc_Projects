package com.hibernateapp.dao;

import org.springframework.stereotype.Repository;

import com.hibernateapp.model.Hotel;

@Repository
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
