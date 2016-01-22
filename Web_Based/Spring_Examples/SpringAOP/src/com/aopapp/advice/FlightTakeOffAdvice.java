package com.aopapp.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class FlightTakeOffAdvice {
	
	public void beforeTakeOff(){
		System.out.println("Before take off instructions...");
	}
	
	public void afterTakeOff(){
		System.out.println("After take off instructions...");
	}
	
	public void afterWarning(){
		System.out.println("After warning instructions...");
	}
	
	public void aroundTakeOff(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Before proceed....");
		joinPoint.proceed();
		System.out.println("After proceed....");
	}
}
