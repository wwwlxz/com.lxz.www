package com.lxz.kafka;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class TestProducer {
	public static void main(String[] args){
		Properties props = new Properties();
		props.setProperty("metadata.broker.list", "123.103.79.120:9092");
		props.setProperty("serializer.class", "kafka.serializer.StringEncoder");
		props.put("request.required.acks", "1");
		ProducerConfig config = new ProducerConfig(props);
		Producer<String, String> producer = new Producer<String, String>(config);
		KeyedMessage<String, String> data = new KeyedMessage<String, String>("my-repliated-topic5", "test-kafka");
		try{
			int i = 1;
			while(i < 1000){
				producer.send(data);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		producer.close();
	}
}
