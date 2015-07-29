package com.lxz.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	public static void main(String[] args) throws UnknownHostException, IOException{
		Socket client = null;
		client = new Socket("localhost", 1234);
		BufferedReader buf = null;
		PrintStream out = null;
		BufferedReader input = null;
		input = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintStream(client.getOutputStream());
		buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
		boolean flag = true;
		while(flag){
			System.out.println("输入信息：");
			String str = input.readLine();
			out.println(str);
			if("bye".equals("str")){
				flag = false;
			}else{
				String echo = buf.readLine();
			}
		}
		client.close();
		buf.close();
	}
}
