package com.lxz.thread.test;

class Zhangsan{
	public void say(){
		System.out.println("张三对李四说：“你给画，我就把书给你”");
	}
	
	public void get(){
		System.out.println("张三得到了画。");
	}
}

class Lisi{
	public void say(){
		System.out.println("李四对张三说：“你给书，我就把画给你”");
	}
	
	public void get(){
		System.out.println("李四得到了书。");
	}
}

class ThreadDeadLock implements Runnable{
	private static Zhangsan zs = new Zhangsan();
	private static Lisi ls = new Lisi();
	public boolean flag = false;
	
	public void run() {
		if(flag){
			synchronized(zs){
				zs.say();
				try{
					Thread.sleep(500);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				synchronized(ls){
					zs.get();
				}
			}
		}else{
			synchronized(ls){
				ls.say();
				try{
					Thread.sleep(500);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				synchronized(zs){
					ls.get();
				}
			}
		}
	}
	
}

public class DeadLockDemo {
	public static void main(String[] args){
		ThreadDeadLock t1 = new ThreadDeadLock();
		ThreadDeadLock t2 = new ThreadDeadLock();
		t1.flag = true;	
		t2.flag = false;
		Thread thA = new Thread(t1);
		Thread thB = new Thread(t2);
		thA.start();
		thB.start();
	}
}
