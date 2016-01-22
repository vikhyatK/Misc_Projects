package com.aopapp.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterTakeOffAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] arguments,
			Object target) throws Throwable {
		System.out.println("After take off instructions...");
	}

}
