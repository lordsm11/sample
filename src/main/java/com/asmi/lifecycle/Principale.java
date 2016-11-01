package com.asmi.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.asmi.lifecycle.config.AppConfig;

public class Principale{
	
	public static void main(String[] args) throws Exception {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		context.getBean(Calcul.class).sum(1, 2);
		
		context.close();
		
	}

}
