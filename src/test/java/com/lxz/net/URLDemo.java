package com.lxz.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class URLDemo {
	public static void main(String[] args) throws IOException{
		URL url = new URL("http", "www.baidu.com", 80, "/");//指定操作的URL
		InputStream input = url.openStream();//打开输入流，读取URL内容
		Scanner scan = new Scanner(input);//实例化Scanner对象
		scan.useDelimiter("\n");//设置读取分隔符
		while(scan.hasNext()){//不断读取内容
			System.out.println(scan.next());//输出内容
		}
	}
}
