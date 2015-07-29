package com.lxz.net;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {
	public static void main(String[] args) throws IOException{
		ServerSocket server = null;
		Socket client = null;//一个socket对象表示一个客户端
		PrintStream out = null;//声明打印流对象，以向客户端输出
		server = new ServerSocket(1234);
		System.out.println("服务器运行，等待客户端连接");
		client = server.accept();//程序阻塞，等待客户端连接
		String str = "Hello World!";
		out = new PrintStream(client.getOutputStream());//实例化打印流对象，输出信息
		out.println(str);//输出信息
		out.close();
		client.close();
		server.close();
	}
}
