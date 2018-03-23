package com.yunjinrong.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.yunjinrong.entity.AgeValidator;
import com.yunjinrong.entity.Person;

public class TestAnnotation {

	@Test
	public void testAnnotation() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Person person3 = new Person();
		person3.setAge(11);
		
		String className ="com.yunjinrong.entity.Person";
		Class clazz = Class.forName(className);
		
		Object obj = clazz.newInstance();
		
		Method method = clazz.getDeclaredMethod("setAge", Integer.class);
		
		int val = 400;
		
		Annotation annotation = method.getAnnotation(AgeValidator.class);
		
		if(annotation != null) {
			if(annotation instanceof AgeValidator) {
				AgeValidator ageValidator =(AgeValidator)annotation;
				if(val < ageValidator.min() || val > ageValidator.max()) {
					System.out.println("数值超出范围");
					throw new RuntimeException("数值超出范围");
				}
			}
		}
				
		method.invoke(obj, val);
		System.out.println(obj);
	}
	
}
