package com.aopapp.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class AnnotationAdvice {
	
	@Pointcut("execution(* com.aopapp.manager.*.takeOff*(..))")
	public void takeOffAdvice(){
		
	}
	
	@Before("takeOffAdvice()")
	public void beforeTakeOff(){
		System.out.println("Before take off instructions...");
	}
	
	@After("takeOffAdvice()")
	public void afterTakeOff(){
		System.out.println("After take off instructions...");
	}
	
	@AfterReturning("takeOffAdvice()")
	public void afterReturningTakeOff(){
		System.out.println("After take off instructions...");
	}
	
	@AfterThrowing("takeOffAdvice()")
	public void afterWarning(){
		System.out.println("After warning instructions...");
	}
	
	@Around("takeOffAdvice()")
	public void aroundTakeOff(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Before proceed...");
		joinPoint.proceed();
		System.out.println("After proceed...");
	}
}
