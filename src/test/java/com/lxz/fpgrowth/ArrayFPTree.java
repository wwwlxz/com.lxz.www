package com.lxz.fpgrowth;

import java.util.HashMap;
import java.util.Map;

public class ArrayFPTree {
	private int minSupport;
	
	public int getMinSupport(){
		return minSupport;
	}
	
	public void setMinSupport(int minSupport){
		this.minSupport = minSupport;
	}
	
	public static void main(String[] args){
		ArrayFPTree arrayFPTree = new ArrayFPTree();
		arrayFPTree.setMinSupport(3);//设置最小支持度为3
	}
}
