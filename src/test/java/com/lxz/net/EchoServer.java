package com.lxz.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) throws IOException{
		ServerSocket server = null;
		Socket client = null;
		PrintStream out = null;
		BufferedReader buf = null;
		server = new ServerSocket(1234);
		boolean f = true;
		while(f){
			System.out.println("服务器运行，等待客户端连接");
			client = server.accept();
			buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintStream(client.getOutputStream());
			boolean flag = true;
			
			while(flag){
				String str = buf.readLine();
				if(str == null || "".equals(str)){
					flag = false;
				}else{
					if("bye".equals(str)){
						flag = false;
					}else{
						out.println("ECHO:" + str);
					}
				}
			}
			out.close();
			client.close();
		}
		server.close();
	}
}
