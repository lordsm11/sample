package com.asmi.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Calcul implements InitializingBean,DisposableBean {

	@PostConstruct
	public void postConstruct() {
		System.out.println("postConstruct");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("preDestroy");
	}
	
	public void sum(int nombre1, int nombre2) {
		System.out.println(String.format("%s+%s=%s",nombre1,nombre2,nombre1+nombre2));
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean : afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean : destroy");
	}
	
    public void initMethod() {
		System.out.println("init-metgo");
    }

    public void detroyMethod() {
		System.out.println("destroy-method");
    }

}
