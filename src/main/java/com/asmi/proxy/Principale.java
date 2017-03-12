
package com.asmi.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.asmi.proxy.config.AppConfig;

@Component("principale")
public class Principale{
	
	@Autowired
	private CalculInterface calculProxy;

	@Autowired
	private Calcul calculImplProxyCglib;

	@Autowired
	private CalculInterface calculProxyCglib;

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Principale principale = context.getBean("principale",Principale.class);
		principale.execute();
	}

	public void execute() throws Exception {

		System.out.println("test du proxy avec reflection");
		System.out.println(calculProxy.sum(1, 2));
		
		System.out.println("test du proxy avec cglib (classe sans interface)");
		System.out.println(calculImplProxyCglib.sum(1, 2));
		
		System.out.println("test du proxy avec cglib (classe avec interface)");
		System.out.println(calculProxyCglib.sum(1, 2));

	}

}
