package com.lxz.reflect;

class Test{
	
}

public class GetClassDemo {
	public static void main(String[] args){
		Class<?> c1 = null;
		Class<?> c2 = null;
		Class<?> c3 = null;
		try{
			c1 = Class.forName("com.lxz.reflect.Test");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		c2 = new Test().getClass();
		c3 = Test.class;
		System.out.println("类名称： " + c1.getName());
		System.out.println("类名称： " + c2.getName());
		System.out.println("类名称： " + c3.getName());
	}
}
