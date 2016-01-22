package com.springcore.mytravel.manager;

import com.springcore.mytravel.dao.CabDao;
import com.springcore.mytravel.model.Cab;

public class CabManager {
	CabDao cabDao;
	
	public CabDao getCabDao() {
		return cabDao;
	}

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
