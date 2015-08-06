package com.lxz.callback.test;

/*
 * 业务处理类
 */
public class Main {
	public static void main(String[] args){
		Caller caller = new Caller();
		caller.setCallBack(new CallBackListener());
		//在业务处理的时候调用
		caller.call();
	}
}
