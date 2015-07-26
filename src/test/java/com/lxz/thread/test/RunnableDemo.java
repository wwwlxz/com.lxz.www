package com.lxz.thread.test;

class MyThread implements Runnable{
	private String name;
	
	public MyThread(String name){		
		this.name = name;
	}
	
	public void run() {
		for(int i = 0; i< 10; i++){
			System.out.println(name + "运行， i=" + i);
		}
	}
}

public class RunnableDemo {
	public static void main(String[] args){
		MyThread my1 = new MyThread("线程A");
		MyThread my2 = new MyThread("线程B");
		Thread t1 = new Thread(my1);
		Thread t2 = new Thread(my2);
		t1.start();
		t2.start();
	}
}
