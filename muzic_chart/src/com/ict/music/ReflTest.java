package com.ict.music;

import java.lang.reflect.Method;

public class ReflTest {
	
	public static void main(String[] args) {
		String classPath = "com.ict.music.Person";
		
		try {
			Class clazz = Class.forName(classPath);
			Object obj = clazz.newInstance();
			System.out.println(obj);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
