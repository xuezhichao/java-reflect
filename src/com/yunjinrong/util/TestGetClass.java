package com.yunjinrong.util;

import org.junit.jupiter.api.Test;

import com.yunjinrong.entity.Person;

public class TestGetClass {

	@SuppressWarnings("rawtypes")
//	@Test
	public void testGetClass() throws ClassNotFoundException {
		
		Class clazz = null;
		
		clazz=Person.class;
		System.out.println("通过类名："+clazz);
		
		System.out.println("----");
		
		
		Object obj = new Person();
		clazz = obj.getClass();
		System.out.println("通过getclass():" + clazz);
		
		clazz = Class.forName("com.yunjinrong.entity.Person");
		System.out.println("通过全类名获取："+clazz);
	}
	
	@Test
	@SuppressWarnings("rawtypes")
	public void testNewInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class clazz = Class.forName("com.yunjinrong.entity.Person");
		
		//使用class类的newInstance()方法创建类的一个对象
		//实际调用的类的无参构造器
		Object obj = clazz.newInstance();
		System.out.println(obj);
		
		clazz = obj.getClass();
		System.out.println(clazz);
	}
	
}
