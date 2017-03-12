package com.asmi.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Principale.class);

	public int sum(int a, int b) {
		int somme = a+b;
		LOGGER.info("somme = "+somme);
		return somme;
	}

	public int divide(int a, int b) {
		int divide = a/b;
		LOGGER.info("divide = "+divide);
		return divide;
	}

}
