package com.yunjinrong.entity;


public class StudentInvoke extends PersonInvoke {

	@SuppressWarnings("unused")
	private void  method1(Integer age) {
		System.out.println("Student private void method1,age:"+age);
	}
}
