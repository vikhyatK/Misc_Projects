package com.springcore.mytravel.manager;

import com.springcore.mytravel.dao.TicketDao;
import com.springcore.mytravel.model.Ticket;

public class TicketManager {
	TicketDao ticketDao;
	
	public TicketDao getTicketDao() {
		return ticketDao;
	}

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	public void bookTicket(Ticket ticket){
		getTicketDao().saveTicket(ticket);
	}
	
	public void cancelTicket(long ticketId){
		getTicketDao().cancelTicket(ticketId);
	}
	
	public void printTicket(long ticketId){
		Ticket ticket = getTicketDao().getTicket(ticketId);
		System.out.println(ticket);
	}

}
