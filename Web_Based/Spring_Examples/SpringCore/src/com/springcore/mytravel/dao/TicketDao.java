package com.springcore.mytravel.dao;


import com.springcore.mytravel.model.Ticket;

public class TicketDao extends GenericDao{
	
	public Ticket getTicket(long ticketId){
		Ticket ticket = null;
		System.out.println("Retrieved ticket!");
		return ticket;
	}
	
	public void saveTicket(Ticket ticket){
		System.out.println("Flight ticket booked!");
	}
	
	public void cancelTicket(long ticketId){
		System.out.println("Flight ticket cancelled!");
	}

}
