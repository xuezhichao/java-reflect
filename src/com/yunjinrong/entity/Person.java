package com.yunjinrong.entity;

public class Person {
	
	private String name;
	
	private int age;
	
	private void privateMethod() {}
	
	public Person() {
		System.out.println("无参构造器");
	}
	
	public Person(String name,int age) {
		System.out.println("有参构造器");
		this.name=name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setName(String name,int age) {
		System.out.println("name="+name);
		System.out.println("age="+age);
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
