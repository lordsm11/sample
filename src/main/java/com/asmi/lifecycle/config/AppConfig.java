package com.asmi.lifecycle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.asmi.lifecycle.Calcul;

@Configuration
public class AppConfig {
	
    @Bean
    public Calcul calcul() {
        return new Calcul();
    }

}