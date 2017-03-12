package com.asmi.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculHandler implements InvocationHandler{
	
	private Object impl;
	
	public CalculHandler(Object impl) {
		this.impl = impl;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(impl,args)+" - reflection proxy";
	}

}
