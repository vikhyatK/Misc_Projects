package com.hibernateapp.manager;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hibernateapp.model.Cab;
import com.hibernateapp.model.Hotel;
import com.hibernateapp.model.Ticket;

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

	public void bookFlight(String passengerName) {
		Ticket ticket = new Ticket();
		ticket.setFlightNumber("320A");
		ticket.setPassengerName(passengerName);
		ticket.setTime(new Date());
		ticketManager.bookTicket(ticket);
		ticketManager.printTicket(3);
	}
	
	public void cancelFlight(long ticketId) {
		ticketManager.cancelTicket(ticketId);
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
