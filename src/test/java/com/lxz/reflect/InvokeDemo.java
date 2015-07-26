package com.lxz.reflect;

import java.lang.reflect.Method;

class Student{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString(){
		return "姓名：" + this.name + "，年龄" + this.age;
	}
}

public class InvokeDemo {
	public static void main(String[] args){
		Class<?> c1 = null;
		Object obj = null;
		try{
			c1 = Class.forName("com.lxz.reflect.Student");
			//System.out.println(c1);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			obj = c1.newInstance();//实例化操作
			//System.out.println(obj.toString());
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}
		setter(obj, "name", "Lxz", String.class);
		setter(obj, "age", 30, int.class);
		System.out.println("姓名：");
		getter(obj, "name");
		System.out.println("年龄：");
		getter(obj,"age");
	}
	
	public static void setter(Object obj, String att, Object value, Class<?> type){
		try{
			Method met = obj.getClass().getMethod("set" + initStr(att), type);
			met.invoke(obj, value);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void getter(Object obj, String att){
		try{
			Method met = obj.getClass().getMethod("get" + initStr(att));
			System.out.println(met.invoke(obj));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String initStr(String old){
		String str = old.substring(0, 1).toUpperCase() + old.substring(1);
		return str;
	}
}
