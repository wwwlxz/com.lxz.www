package com.lxz.annotation;

@Deprecated //表示不建议使用
class Demo{
	public String getInfo(){
		return "Animal";
	}
}

public class DeprecatedAnnotationDemo {
	public static void main(String[] args){
		Demo demo = new Demo();
		System.out.println(demo.getInfo());
	}
}
