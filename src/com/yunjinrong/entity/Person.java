package com.yunjinrong.entity;

public class Person {
	
	private String name;
	
	private Integer age;
	
	private void privateMethod() {}
	
	public Person() {
		System.out.println("无参构造器");
	}
	
	public Person(String name,Integer age) {
		System.out.println("有参构造器");
		this.name=name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	@AgeValidator(max = 100, min = 0)
	public void setAge(Integer age) {
		this.age = age;
	}

	
}
