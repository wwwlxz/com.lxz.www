package com.lxz.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
	public static void main(String[] args) throws IOException{
		InetAddress locAdd = null;
		InetAddress remAdd = null;
		locAdd = InetAddress.getLocalHost();
		remAdd = InetAddress.getByName("www.baidu.com");
		System.out.println("本机IP地址：" + locAdd.getHostAddress());
		System.out.println("www.baidu.com的IP地址：" + remAdd.getHostAddress());
		System.out.println("本机是否可达：" + locAdd.isReachable(5000));
	}
}
