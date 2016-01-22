package com.springcore.mytravel.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springcore.mytravel.model.Cab;
import com.springcore.mytravel.model.Hotel;
import com.springcore.mytravel.model.Ticket;

@Component
public class TravelManager {
    
	TicketManager ticketManager;
	CabManager cabManager;
	HotelManager hotelManager;

	public TicketManager getTicketManager() {
		return ticketManager;
	}
    
	@Autowired
	public void setTicketManager(TicketManager ticketManager) {
		this.ticketManager = ticketManager;
	}

	public CabManager getCabManager() {
		return cabManager;
	}

	@Autowired
	public void setCabManager(CabManager cabManager) {
		this.cabManager = cabManager;
	}

	public HotelManager getHotelManager() {
		return hotelManager;
	}

	@Autowired
	public void setHotelManager(HotelManager hotelManager) {
		this.hotelManager = hotelManager;
	}

	public void bookFlight() {
		Ticket ticket = new Ticket();
		ticketManager.bookTicket(ticket);
	}

	public void bookCab() {
		Cab cab = new Cab();
		cabManager.bookCab(cab);
	}

	public void bookHotel() {
		Hotel hotel = new Hotel();
		hotelManager.bookHotel(hotel);
	}

}
