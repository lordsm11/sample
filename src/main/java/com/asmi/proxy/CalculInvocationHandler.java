package com.asmi.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CalculInvocationHandler implements MethodInterceptor {

	private Object impl;
	
	public CalculInvocationHandler(Object impl) {
		this.impl = impl;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		return proxy.invoke(impl, args)+"- cglib proxy";
	}

}
