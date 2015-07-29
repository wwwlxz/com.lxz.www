package com.lxz.net;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDemo {
	public static void main(String[] args) throws IOException{
		URL url = new URL("http://www.baidu.com");
		URLConnection urlCon = url.openConnection();
		System.out.println("内容大小：" + urlCon.getContentLength());
		System.out.println("内容类型：" + urlCon.getContentType());
	}
}
