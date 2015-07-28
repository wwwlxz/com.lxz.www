package com.lxz.annotation;

class Person{
	public String getInfo(){
		return "这是一个Person类";
	}
}

class Student extends Person{
	@Override
	public String getInfo(){
		return "这是一个Student类";
	}
}

public class OverrideAnnotationDemo {
	public static void main(String[] args){
		Person per = new Student();
		System.out.println(per.getInfo());
	}
}
