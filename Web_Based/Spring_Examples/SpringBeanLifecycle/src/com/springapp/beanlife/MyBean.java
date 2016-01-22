package com.springapp.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MyBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware{
	DependentBean dependentBean;
	
	public MyBean(){
		System.out.println("MyBean instance is created");
	}
	
	public DependentBean getDependentBean() {
		return dependentBean;
	}

	public void setDependentBean(DependentBean dependentBean) {
		this.dependentBean = dependentBean;
		System.out.println("Set DependentBean property for MyBean");
	}
	
	//Init

	@PostConstruct
    public void postConstruct(){
		System.out.println("Post construct");
    }

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("After properties set");
		
	}
	
	public void customInit(){
		System.out.println("Custom init");
	}
	
	
	//Aware methods
	@Override
	public void setBeanName(String name) {
		System.out.println("Set Bean name: " + name);
	}
	
	@Override
	public void setBeanFactory(BeanFactory factory) throws BeansException {
     System.out.println("Set Bean Factory");		
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
	     System.out.println("Set Application context");		
	}
	
	
	//Destroy
	@PreDestroy
	public void preDestory(){
		System.out.println("Pre destroy");
	}
	
	@Override
	public void destroy(){
		System.out.println("Destroy");
	}
	
	public void customDestroy(){
		System.out.println("Custom destroy");
	}

}
