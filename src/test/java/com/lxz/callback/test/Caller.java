package com.lxz.callback.test;

/*
 * 调用类
 */
public class Caller {
	private ICallBack callBack;
	
	public void setCallBack(ICallBack callBack){
		this.callBack = callBack;
	}
	
	public void call(){
		this.callBack.callBackMethod();
	}
}
