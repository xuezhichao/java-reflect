package com.yunjinrong.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

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
	
	//@Test
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
	
	@Test
	public void testMethod() throws ClassNotFoundException, 
					NoSuchMethodException, SecurityException, 
					InstantiationException, IllegalAccessException, 
					IllegalArgumentException, InvocationTargetException {
		
		Class clazz = Class.forName("com.yunjinrong.entity.Person");
		
		//得到 clazz对应的类中的那些方法，不能获取private方法
		Method methods[] = clazz.getMethods();
		
		for(Method m : methods) {
			System.out.print(m.getName()+",");
		}
		
		//获取所有的方法（且只获取当前类声明的方法，包括private方法）
		Method methods2[] =clazz.getDeclaredMethods();
		System.out.println("");
		for(Method m:methods2) {
			System.out.print(m.getName()+",");
		}
		
		Method method = clazz.getDeclaredMethod("setName", String.class);
		
		System.out.println("\nmethod:"+method);
		
		Method method2 = clazz.getDeclaredMethod("setName", String.class, int.class);
		
		System.out.println("method2:"+method2);
		
		Object obj = clazz.newInstance();
		method2.invoke(obj, "张三",123);
		
	}
	
}
