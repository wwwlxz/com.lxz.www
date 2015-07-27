package com.lxz.reflect;

import java.lang.reflect.Field;

public class InvokeFieldDemo {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException{
		Class<?> c1 = null;
		Object obj = null;
		c1 = Class.forName("com.lxz.reflect.Student");
		obj = c1.newInstance();
		Field nameField = null;
		Field ageField = null;
		nameField = c1.getDeclaredField("name");
		ageField = c1.getDeclaredField("age");
		nameField.setAccessible(true);//扩大了属性的访问权限
		nameField.set(obj, "Lxz");
		ageField.setAccessible(true);
		ageField.set(obj, 20);
		System.out.println("name: " + nameField.get(obj));
		System.out.println("age: " + ageField.get(obj));
	}
}
