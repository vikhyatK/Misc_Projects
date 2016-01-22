package com.springapp.di.setterdi;

import com.springapp.model.Ticket;

public class TicketManager {
	Ticket ticket = null;
	
	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public void printTicket(){
		System.out.println("****************************");
		System.out.println(ticket.getInfo());
		System.out.println("****************************");
	}
	

}
