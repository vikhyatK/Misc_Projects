package com.aopapp.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class AfterErrorAdvice implements ThrowsAdvice {
	public void afterThrowing(Exception ex) throws Throwable {
		System.out.println("After error instructions...");
	}

	public void afterThrowing(Method method, Object[] args, Object target,
			Exception ex) {
		System.out.println("After error instructions...");
	}
}
