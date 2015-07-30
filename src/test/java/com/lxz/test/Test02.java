package com.lxz.test;

import java.lang.reflect.Field;

public class Test02 {
	public static void main(String[] args) throws Exception{
		Person person = new Person();
//		Field f = person.getClass().getField("toString");
//		System.out.println(f.get(person));
		
		String[] strs = new String[]{"dsdf", "fsdfds", "gdfgfd"};
		System.out.println(strs.getClass());
		Object per = person.getClass().newInstance();
		System.out.println(per.toString());
//		System.out.println(person.getClass().getName());
//		Object obj = new Person();
//		System.out.println(Class.forName("com.lxz.test.Person"));
//		System.out.println(obj.toString());
//		System.out.println(Person.class.getClassLoader());
//		if(person.getClass() == Person.class){
//			System.out.println("true");
//		};
	}
}
