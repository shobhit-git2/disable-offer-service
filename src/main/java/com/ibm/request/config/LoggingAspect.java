package com.ibm.request.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("allMethodsPointcut()")
	public void logBeforeMethod(JoinPoint joinpoint) {
		logger.info("Entering method:" + joinpoint.getSignature().getDeclaringTypeName()
				+ joinpoint.getSignature().getName());
	}

	@After("allMethodsPointcut()")
	public void logAfterMethod(JoinPoint joinpoint) {
		logger.info("Exiting method:" + joinpoint.getSignature().getDeclaringTypeName()
				+ joinpoint.getSignature().getName());
	}

	@Pointcut("execution(* com.ibm.request..*.*(..))|| "
			+ "execution(* com.ibm.request.controller..*.*(..))|| "
			+ "execution(* com.ibm.request.service.impl..*.*(..)) ")
	public void allMethodsPointcut() {
	}
}
