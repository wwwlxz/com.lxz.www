package com.lxz.thread.test;

class MyThreadSync1 implements Runnable{
	private int ticket = 5;
	
	public void run() {
		for(int i = 0; i< 100; i++){
			synchronized(this){
				if(ticket > 0){
					try{
						Thread.sleep(3);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					System.out.println("卖票：ticket = " + ticket--);
				}
			}
		}
	}
	
}

class MyThreadSync2 implements Runnable{
	private int ticket = 5;
	
	public void run() {
		for(int i = 0; i< 100; i++){
			this.sale();
		}
	}
	
	public synchronized void sale(){
		if(ticket > 0){
			try{
				Thread.sleep(3);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("卖票：ticket = " + ticket--);
		}
	}
	
}

public class SyncDemo {
	public static void main(String[] args){
		MyThreadSync2 mt = new MyThreadSync2();
		Thread t1 = new Thread(mt);
		Thread t2 = new Thread(mt);
		Thread t3 = new Thread(mt);
		t1.start();
		t2.start();
		t3.start();
	}
}
