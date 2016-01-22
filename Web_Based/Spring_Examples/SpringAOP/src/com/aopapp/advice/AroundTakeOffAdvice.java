package com.aopapp.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundTakeOffAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("Before take off instructions...");
		Object result = methodInvocation.proceed();
		System.out.println("After take off instructions...");
		return result;
	}

}
