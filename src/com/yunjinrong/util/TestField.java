package com.yunjinrong.util;

import java.lang.reflect.Field;

public class TestField {
	
	public void testField() throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		
		Class clazz = Class.forName("com.yunjinrong.entity.Person");;
		
		Field[] fields = clazz.getDeclaredFields();
		for(Field field:fields) {
			System.out.println(field.getName()+",");
		}
		
		Field field = clazz.getDeclaredField("name");
		
		
	}

}
