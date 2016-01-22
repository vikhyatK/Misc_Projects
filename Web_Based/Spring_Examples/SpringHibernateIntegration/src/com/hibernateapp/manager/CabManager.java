package com.hibernateapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hibernateapp.dao.CabDao;
import com.hibernateapp.model.Cab;

@Component
public class CabManager {
	CabDao cabDao;
	
	public CabDao getCabDao() {
		return cabDao;
	}

	@Autowired
	public void setCabDao(CabDao cabDao) {
		this.cabDao = cabDao;
	}

	public Cab getCab(long bookingId){
		return getCabDao().getCabBooking();
	}
	
	public void bookCab(Cab cab){
		getCabDao().saveCabBooking(cab);
	}
	
	public void cancelCab(long bookingId){
		getCabDao().cancelCabBooking(bookingId);
	}

}
