package com.lxz.reflect.proxy;

public class DynaProxyDemo {
	public static void main(String[] args){
		MyInvocationHandler handler = new MyInvocationHandler();//实例化代理操作类
		Subject sub = (Subject)handler.bind(new RealSubject());//绑定对象
		String info = sub.say("Lxz", 20);//通过动态代理调用方法
		System.out.println(info);//输出信息
	}
}
