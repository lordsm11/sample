package com.asmi.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.asmi.aop.Principale;

@Aspect
@Configuration
public class AspectConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(Principale.class);

	@Before("execution(public * *(..))")    
	public void all(JoinPoint joinPoint) {
		LOGGER.info("before execution(public * *(..))");
	}

	@Before("execution(* sum(..))")    
	public void allMethos(JoinPoint joinPoint) {
		LOGGER.info("before execution(* sum(..))");
	}

	@Before("execution(* com.asmi.*.*(..))")    
	public void allMethosPackage(JoinPoint joinPoint) {
		LOGGER.info("before execution(* com.asmi.*.*(..))");
	}

	@Before("execution(* com.asmi.aop.*.*(..))")    
	public void allMethosPackageOk(JoinPoint joinPoint) {
		LOGGER.info("before execution(* com.asmi.aop.*.*(..))");
	}

	@Before("execution(* com.asmi..*.*(..))")    
	public void allMethosPackageAndSub(JoinPoint joinPoint) {
		LOGGER.info("before execution(* com.asmi..*.*(..)))");
	}

	@Before("execution(* com.asmi.aop.CalculService..*(..))")    
	public void logBefore(JoinPoint joinPoint) {
		LOGGER.info("before calling method "+joinPoint.getSignature().getName());
	}

	@After("execution(* com.asmi.aop.CalculService..*(..))")    
	public void logAfter(JoinPoint joinPoint) {
		LOGGER.info("after calling method "+joinPoint.getSignature().getName());
	}

	@AfterReturning("execution(* com.asmi.aop.CalculService..*(..))")    
	public void logAfterReturning(JoinPoint joinPoint) {
		LOGGER.info("AfterReturning calling method "+joinPoint.getSignature().getName());
	}

	@AfterThrowing("execution(* com.asmi.aop.CalculService..*(..))")    
	public void logAfterThrowing(JoinPoint joinPoint) {
		LOGGER.info("AfterThrowing calling method "+joinPoint.getSignature().getName());
	}

}