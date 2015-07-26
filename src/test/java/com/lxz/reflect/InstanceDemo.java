package com.lxz.reflect;

import java.lang.reflect.Constructor;

class Person{
	private String name;
	private int age;
	public Person(String name, int age){
		this.setName(name);
		this.setAge(age);
	}
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

public class InstanceDemo {
	public static void main(String[] args){
		Class<?> c = null;
		try{
			c = Class.forName("com.lxz.reflect.Person");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Person per = null;
		Constructor<?> cons[] = null;
		cons = c.getConstructors();
		try{
			per = (Person)cons[0].newInstance("Lxz", 20);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(per);
	}
}
