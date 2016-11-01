package com.asmi.proxy.config;

import java.lang.reflect.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.asmi.proxy.Calcul;
import com.asmi.proxy.CalculHandler;
import com.asmi.proxy.CalculImpl;
import com.asmi.proxy.CalculInterface;
import com.asmi.proxy.CalculInvocationHandler;

import net.sf.cglib.proxy.Enhancer;

@Configuration
@ComponentScan("com.asmi.proxy")
public class AppConfig {
	
	@Autowired
	private CalculImpl calculImpl;
	
	@Autowired
	private Calcul calcul;
	
	@Bean
	public CalculInterface calculProxy() {
		return (CalculInterface) Proxy.newProxyInstance(
				CalculInterface.class.getClassLoader(),
		                            new Class[] { CalculInterface.class },
		                            calculHandler());

	}
	
	@Bean
	public CalculInterface calculProxyCglib() {
		return (CalculInterface) Enhancer.create(CalculInterface.class, calculInvocationHandlerImpl());

	}
	
	@Bean
	public Calcul calculImplProxyCglib() {
		return (Calcul) Enhancer.create(Calcul.class, calculInvocationHandler());
	}
	
	@Bean
	public CalculInvocationHandler calculInvocationHandler() {
		return new CalculInvocationHandler(calcul);
	}

	@Bean
	public CalculInvocationHandler calculInvocationHandlerImpl() {
		return new CalculInvocationHandler(calculImpl);
	}

	@Bean
    public CalculHandler calculHandler() {
    	return new CalculHandler(calculImpl);
    }


}