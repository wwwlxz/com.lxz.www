package com.lxz.thread.test;

public class ThreadDemo extends Thread{
	private String test;
	public ThreadDemo(){
		
	}
	
	public ThreadDemo(String test){
		this.test = test;
	}
	
	public void run(){
		for(int i = 0; i < 20; i++){
			System.out.println(test + "time:" + i);
		}
	}
	
	public static void main(String[] args){
		ThreadDemo threadA = new ThreadDemo("A");
		ThreadDemo threadB = new ThreadDemo("B");
		threadA.start();
		threadB.start();
		//System.out.println(Thread.currentThread().getName());
	}

}
