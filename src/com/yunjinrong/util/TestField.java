package com.yunjinrong.util;

import java.lang.reflect.Field;

import org.junit.Test;

import com.yunjinrong.entity.Person2;

public class TestField {
	
	@Test
	public void testField() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		Class clazz = Class.forName("com.yunjinrong.entity.Person2");;
		
		Field[] fields = clazz.getDeclaredFields();
		for(Field field:fields) {
			System.out.println(field.getName()+",");
		}
		
		Field field = clazz.getDeclaredField("name");
		System.out.println("获取指定Field名="+field.getName());

		Person2 person = new Person2("张三",12);
		field.setAccessible(true);
		Object val = field.get(person);
		System.out.println("获取指定对象字段'name'的Field的值=："+val);
		
		field.set(person, "李四");
		
		System.out.println("设置指定对象字段‘name’的field的值：="+person.getName());
		
		
		Field field2 =clazz.getDeclaredField("age");
		field2.setAccessible(true);
		System.out.println("获取指定私有字段名："+field2.getName());
		
		
	}

}
