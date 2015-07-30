package com.lxz.test;

class Person{
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
		return "I'm a person";
	}
}

class Student extends Person{
	private String school;

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	public String toString(){
		return "hello";
	}
}

public class Test01 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException{
		Person person = (Person) getImplClass().newInstance();
		System.out.println(Person.class.isInterface());
		System.out.println(person.toString());
	}
	
	private static Class<?> getImplClass(){
		try{
			return Class.forName("com.lxz.test.Student");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return null;
	}
}
