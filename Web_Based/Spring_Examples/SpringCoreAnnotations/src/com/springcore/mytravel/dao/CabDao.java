package com.springcore.mytravel.dao;

import org.springframework.stereotype.Repository;

import com.springcore.mytravel.model.Cab;

@Repository
public class CabDao extends GenericDao{
	
	public Cab getCabBooking(){
		Cab cab = null;
		System.out.println("Retrieved cab booking!");
		return cab;
	}
	
	public void saveCabBooking(Cab cab){
		System.out.println("Cab booked!");
	}
	
	public void cancelCabBooking(long bookingId){
		System.out.println("Cab cancelled!");
	}

}
