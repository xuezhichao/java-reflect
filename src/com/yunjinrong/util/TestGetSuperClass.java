package com.yunjinrong.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.yunjinrong.entity.StudentInvoke;

public class TestGetSuperClass {

	
//	@Test
	@SuppressWarnings("rawtypes")
	public void testGetSuperClass() throws ClassNotFoundException {
		String className = "com.yunjinrong.entity.StudentInvoke";
		
		Class clazz = Class.forName(className);
		
		Class superClass = clazz.getSuperclass();
		
		System.out.println(superClass);
		
	}
	
	public Object invoke(Object obj,String methodName,Object ...args) {
		Class[] parameterType = new Class[args.length];
		
		for(int i=0;i < args.length;i++) {
			parameterType[i] = args[i].getClass();
		}
		
		Method method = getMethod(obj.getClass(),methodName,parameterType);
		
		method.setAccessible(true);
		
		try {
			return method.invoke(obj, args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Method getMethod(Class clazz,String methodName,Class ...parameterTypes) {
		for(;clazz != Object.class;clazz = clazz.getSuperclass()) {
			try {
				return clazz.getDeclaredMethod(methodName, parameterTypes);
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	@Test
	public void testInvoke2() {
		Object obj = new StudentInvoke();
		invoke(obj, "method1",10);
		
		
		Object result = invoke(obj,"method2");
		System.out.println(result);
	}
	
}
