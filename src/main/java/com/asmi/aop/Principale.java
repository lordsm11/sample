package com.asmi.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.asmi.aop.config.AppConfig;

public class Principale {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CalculService calcul = context.getBean(CalculService.class);
		calcul.sum(5,8);
		/*
		calcul.divide(8,4);
		try {
			calcul.divide(8,0);
		} catch (Exception e) {
		}*/
	}

}
