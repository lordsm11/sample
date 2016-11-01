package com.asmi.proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.asmi.proxy.config.AppConfig;

public class Principale{
	
	public static void main(String[] args) throws Exception {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		System.out.println("test du proxy avec reflection");
		System.out.println(context.getBean("calculProxy",CalculInterface.class).sum(1, 2));
		
		System.out.println("test du proxy avec cglib (classe sans interface)");
		System.out.println(context.getBean("calculImplProxyCglib",Calcul.class).sum(1, 2));
		
		System.out.println("test du proxy avec cglib (classe avec interface)");
		System.out.println(context.getBean("calculProxyCglib",CalculInterface.class).sum(1, 2));

	}

}
