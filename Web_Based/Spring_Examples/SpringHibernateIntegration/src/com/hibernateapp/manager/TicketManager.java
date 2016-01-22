package com.hibernateapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hibernateapp.dao.TicketDao;
import com.hibernateapp.model.Ticket;

@Component
public class TicketManager {
	TicketDao ticketDao;
	
	public TicketDao getTicketDao() {
		return ticketDao;
	}

	@Autowired
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void bookTicket(Ticket ticket){
		getTicketDao().saveTicket(ticket);
		//getTicketDao().saveTicketWithTemplate(ticket);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void cancelTicket(long ticketId){
		getTicketDao().cancelTicket(ticketId);
	}
	
	@Transactional(readOnly=true)
	public void printTicket(long ticketId){
		Ticket ticket = getTicketDao().getTicket(ticketId);
		System.out.println(ticket);
	}

}
