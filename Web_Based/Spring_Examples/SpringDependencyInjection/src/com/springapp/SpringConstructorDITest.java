package com.springapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springapp.di.constructordi.TicketManager;

public class SpringConstructorDITest {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		
		TicketManager ticketManager = context.getBean("ticketManager", TicketManager.class);
		ticketManager.printTicket();
	}
}
