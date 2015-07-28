package com.lxz.reflect.proxy;

public class RealSubject implements Subject{//真实实现类

	public String say(String name, int age) {
		return "姓名：" + name + ", 年龄：" + age;
	}

}
