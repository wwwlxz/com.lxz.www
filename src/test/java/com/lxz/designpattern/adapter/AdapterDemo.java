package com.lxz.designpattern.adapter;

interface Window{
	public void open();
	public void close();
	public void acticated();
	public void iconified();
	public void deiconified();
}

abstract class WindowAdapter implements Window{
	public void acticated(){}
	public void open(){}
	public void close(){}
	public void iconified(){}
	public void deiconified(){}
}

class WindowImpl extends WindowAdapter{
	public void open(){
		System.out.println("窗口打开");
	}
	
	public void close(){
		System.out.println("窗口关闭");
	}
}

public class AdapterDemo {
	public static void main(String[] args){
		Window win = new WindowImpl();
		win.open();
		win.close();
	}
}
