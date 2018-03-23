package com.yunjinrong.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class TestClassLoader {

//	@Test
	public void testClassLoader() throws ClassNotFoundException {
		//获取一个系统的类加载器
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统的类加载器-->"+classLoader);
		
		//获取系统类加载器的父类加载器（扩展类加载器（extensions classLoader））
		classLoader = classLoader.getParent();
		System.out.println("扩展类加载器-->"+classLoader);
		
		//获取扩展类加载器的父类加载器
		classLoader = classLoader.getParent();
		System.out.println("启动类加载器-->"+classLoader);
		
		//测试当前类由哪个类加载器进行加载，结果就是系统的类加载器
		classLoader = Class.forName("com.yunjinrong.entity.Person").getClassLoader();
		System.out.println("当前类由那个类加载器进行加载-->"+classLoader);
		
		classLoader =Class.forName("java.lang.Object").getClassLoader();
		System.out.println("JDK提供的Object类由哪个类加载器加载-->"+classLoader);
		
	}
	
	
	@Test
	public void testGetResourceAsStream() throws IOException {
		
		InputStream in = getClass().getClassLoader().getResourceAsStream("com/yunjinrong/util/test.properties");
		
		System.out.println("in:"+in);
		
		Properties properties = new Properties();
		properties.load(in);
		
		String driverClass = properties.getProperty("driver");
		String jdbc = properties.getProperty("jdbcUrl");
		System.out.println("driverClass:"+driverClass +"jdbc:"+jdbc);
		
		
		String user = properties.getProperty("user");
		System.out.println(user);
		
		user = new String(user.getBytes("ISO8859-1"), "UTF-8");
		System.out.println(user);
		
		String password = properties.getProperty("password");
		System.out.println(password);
	}
	
	
}
