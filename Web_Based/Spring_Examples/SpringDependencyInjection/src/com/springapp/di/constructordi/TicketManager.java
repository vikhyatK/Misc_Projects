package com.springapp.di.constructordi;

import com.springapp.model.Ticket;

public class TicketManager {
	Ticket ticket = null;
	
	public TicketManager(Ticket ticket){
		this.ticket = ticket;
	}
	
	public void printTicket(){
		System.out.println("****************************");
		System.out.println(ticket.getInfo());
		System.out.println("****************************");
	}
	

}
