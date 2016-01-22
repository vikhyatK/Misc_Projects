package com.hibernateapp.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hibernateapp.model.Ticket;

@Repository
public class TicketDao extends GenericDao {
	
	private Session getSession(){
		return getSessionFactory().getCurrentSession();
	}

	public Ticket getTicket(long ticketId) {
       return (Ticket)getSession().get(Ticket.class, ticketId);
	}
	
	public Ticket getTicketWithTemplate(long ticketId) {
           return getHibernateTemplate().get(Ticket.class, ticketId);
		}

	@Transactional(propagation=Propagation.REQUIRED)
	public void saveTicket(Ticket ticket) {
		getSession().save(ticket);
		System.out.println("Flight ticket booked!");
	}

	
	public void saveTicketWithTemplate(Ticket ticket) {
		getHibernateTemplate().save(ticket);
		System.out.println("Flight ticket booked!");
	}
	
	public void cancelTicket(long ticketId) {
		Ticket ticket = getTicket(ticketId);
		getSession().delete(ticket);
		System.out.println("Flight ticket cancelled!");
	}
	
	public void cancelTicketWithTemplate(long ticketId) {
		Ticket ticket = getTicket(ticketId);
		getHibernateTemplate().delete(ticket);
		System.out.println("Flight ticket cancelled!");
	}

}
