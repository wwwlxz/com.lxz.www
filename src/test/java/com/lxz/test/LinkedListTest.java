package com.lxz.test;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args){		
		LinkedList<String> lList = new LinkedList<String>();
		lList.add("1");
		lList.add("2");
		lList.add("3");
		lList.add("4");
		lList.add("5");
		System.out.println("the first element in linkedlist is: " + lList.getFirst());
		System.out.println("the last element in linkedlist is: " + lList.getLast());
	}
}
