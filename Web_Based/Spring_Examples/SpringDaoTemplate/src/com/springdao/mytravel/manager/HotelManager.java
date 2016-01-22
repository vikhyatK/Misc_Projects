package com.springdao.mytravel.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springdao.mytravel.dao.HotelDao;
import com.springdao.mytravel.model.Hotel;

@Component
public class HotelManager {
	HotelDao hotelDao;
	
	public HotelDao getHotelDao() {
		return hotelDao;
	}

	@Autowired
	public void setHotelDao(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	public Hotel getHotel(long bookingId){
		return getHotelDao().getHotelBooking(bookingId);
	}
	
	public void bookHotel(Hotel hotel){
		getHotelDao().saveHotelBooking(hotel);
	}
	
	public void cancelHotel(long bookingId){
		getHotelDao().cancelHotelBooking(bookingId);
	}

}
