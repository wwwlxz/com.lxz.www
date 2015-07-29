package com.lxz.net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CodeDemo {
	public static void main(String[] args) throws UnsupportedEncodingException{
		String keyWord = "中国";
		String encod = URLEncoder.encode(keyWord, "UTF-8");
		System.out.println("编码之后的内容：" + encod);
		String decod = URLDecoder.decode(encod, "UTF-8");
		System.out.println("解码之后的内容：" + decod);
	}
}
