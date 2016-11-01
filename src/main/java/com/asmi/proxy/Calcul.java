package com.asmi.proxy;

import org.springframework.stereotype.Service;

@Service
public class Calcul {

	public String sum(int nombre1, int nombre2) {
		return String.format("%s+%s=%s",nombre1,nombre2,nombre1+nombre2);
	}
}
