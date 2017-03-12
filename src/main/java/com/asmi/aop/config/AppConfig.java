package com.asmi.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.asmi.aop.aspect.AspectConfig;

@Configuration
@ComponentScan("com.asmi.aop")
@EnableAspectJAutoProxy
@Import(AspectConfig.class)
public class AppConfig {
	
    
}