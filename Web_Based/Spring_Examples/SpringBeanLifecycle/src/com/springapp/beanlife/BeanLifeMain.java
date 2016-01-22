package com.springapp.beanlife;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeMain {
	
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		MyBean myBean = context.getBean("myBean", MyBean.class);
	    
	    ((ConfigurableApplicationContext)context).registerShutdownHook();
	}

}
