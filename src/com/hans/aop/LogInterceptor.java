package com.hans.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
	
	@Before("execution(* com.hans.dao.impl.*.*(*))")
	public void before() {
		System.out.println("method start...");
	}
	
	@After("execution(int com.hans.dao.impl.UserDaoImpl.save(com.hans.model.User))")
	public void after() {
		System.out.println("method end .....");
	}
}
