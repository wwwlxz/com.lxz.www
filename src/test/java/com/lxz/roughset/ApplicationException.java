package com.lxz.roughset;

public class ApplicationException extends RuntimeException{
	private static final long serialVersionUID = 23243252315L;
	
	public ApplicationException(String message){
		System.out.println(message);
	}
}
