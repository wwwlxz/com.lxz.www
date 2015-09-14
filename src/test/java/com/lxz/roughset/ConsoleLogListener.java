package com.lxz.roughset;

public class ConsoleLogListener extends LogListener{
	@Override
	public void update(String message, boolean newLine) {
		System.out.println(message);
		if(newLine){
			System.out.println();
		}
	}
}
