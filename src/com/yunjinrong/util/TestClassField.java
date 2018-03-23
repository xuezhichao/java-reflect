package com.yunjinrong.util;

import java.lang.reflect.Field;

import org.junit.Test;

import com.yunjinrong.entity.Student;


public class TestClassField {

	@SuppressWarnings("rawtypes")
	@Test
	public void testClassField() throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		String className = "com.yunjinrong.entity.Student";
		String fieldName = "age";
		
		Object val = 20;
		
		Class clazz=null;
		clazz = Class.forName(className);
		Field field = null;
		
		for(Class clazz2 = clazz;clazz!=Object.class;clazz2=clazz2.getSuperclass()) {
			field =clazz2.getDeclaredField(fieldName);
			if(field != null) {
				break;
			}
		}
		
		Object obj = clazz.newInstance();
		assert field != null;
		
		field.setAccessible(true);
		field.set(obj, val);
		
		Student stu =(Student) obj;
		System.out.println("age="+stu.getAge());
		
		
	}
}
