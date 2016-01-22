package com.springapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.springapp.di.setterdi.TicketManager;

public class SpringSetterDITest {
	
	public static void main(String[] args){
		ApplicationContext context = new FileSystemXmlApplicationContext(
		"D:/SpringExamples/SpringDependencyInjection/conf/applicationContext.xml");
		
		TicketManager ticketManager = context.getBean("ticketManager", TicketManager.class);
		ticketManager.printTicket();
	}
}
