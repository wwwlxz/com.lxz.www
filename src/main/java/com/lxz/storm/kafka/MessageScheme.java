package com.lxz.storm.kafka;

import java.io.UnsupportedEncodingException;
import java.util.List;

import backtype.storm.spout.Scheme;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

/*
 * KafkaSpout
 * KafkaSpout是storm中自带的spout，源码在https://github.com/apache/incubator-storm/tree/master/external
 * 使用KafkaSpout时需要子集实现Scheme接口，它主要负责从消息流中解析出需要的数据
 */
public class MessageScheme implements Scheme{
	
	public List<Object> deserialize(byte[] ser) {//反序列化,从消息流中解析出需要的数据
		try{
			String msg = new String(ser, "UTF-8");
			return new Values(msg);
		}catch(UnsupportedEncodingException e){
			
		}
		return null;
	}

	public Fields getOutputFields() {
		// TODO Auto-generated method stub
		return new Fields("msg");
	}

}
