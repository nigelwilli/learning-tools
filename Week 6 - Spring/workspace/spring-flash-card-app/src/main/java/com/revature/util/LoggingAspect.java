package com.revature.util;

import java.time.LocalTime;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@Pointcut("within(com.revature..*)")
	public void logAll() { }
	
	@Before("logAll()")
	public void logMethodStart(JoinPoint jp) {
		String methodSig = jp.getTarget().getClass().toString() + "." + jp.getSignature().getName();
		logger.info("{} invoked at {}", methodSig, LocalTime.now());
		logger.info("Input arguments: {}", Arrays.toString(jp.getArgs()));
	}
	
	@AfterReturning(pointcut="logAll()", returning="rtrn")
	public void logMethodReturn(JoinPoint jp, Object rtrn) {
		String methodSig = jp.getTarget().getClass().toString() + "." + jp.getSignature().getName();
		logger.info("{} successfully returned at {}", methodSig, LocalTime.now());
		logger.info("Object returned: {}", rtrn);
	}
	
	@AfterThrowing(pointcut="logAll()", throwing="e")
	public void errorOccurrence(JoinPoint jp, Exception e) {
		String methodSig = jp.getTarget().getClass().toString() + "." + jp.getSignature().getName();
		logger.info("{} thrown in method: {}", e.getMessage(), methodSig);
	}

}
