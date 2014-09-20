package com.hans.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {

	@Pointcut("execution(* save(..))")
	public void anyOldTransfer() {}
	
	@Before("anyOldTransfer()")
	public void before() {
		System.out.println("method start...");
	}
	
	@After("anyOldTransfer()")
	public void after() {
		System.out.println("method end .....");
	}
}
