package com.lxz.storm.kafka;

import java.util.HashMap;
import java.util.Map;

import storm.kafka.BrokerHosts;
import storm.kafka.KafkaSpout;
import storm.kafka.SpoutConfig;
import storm.kafka.ZkHosts;
import storm.kafka.bolt.KafkaBolt;
import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.spout.SchemeAsMultiScheme;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;

public class StormKafkaTopo {
	public static void main(String[] args) throws AlreadyAliveException, InvalidTopologyException{
		//配置Zookeeper地址
		BrokerHosts brokerHosts = new ZkHosts("192.168.11.193:2181");
		//配置Kafka订阅的Topic，以及zookeeper中数据节点目录和名字
		SpoutConfig spoutConfig = new SpoutConfig(brokerHosts, "topic1", "/kafka", "kafkaspout");
		
		//配置KafkaBolt中的kafka.broker.properties
		Config conf = new Config();
		Map<String, String> map = new HashMap<String, String>();
		//配置Kafka broker地址
		map.put("metadata.broker.list", "192.168.11.191:9092");
		//serializer.class为消息的序列化类
		map.put("serializer.class", "kafka.serializer.StringEncoder");
		conf.put("kafka.broker.properties", map);
		//配置kafkaBolt生成的Topic
		conf.put("topic", "topic2");
		
		spoutConfig.scheme = new SchemeAsMultiScheme(new MessageScheme());
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("spout", new KafkaSpout(spoutConfig));
		builder.setBolt("bolt", new SenquenceBolt()).shuffleGrouping("spout");
		builder.setBolt("kafkabolt", new KafkaBolt<String, Integer>()).shuffleGrouping("bolt");
		
		if(args != null && args.length > 0){
			conf.setNumWorkers(3);
			StormSubmitter.submitTopology(args[0], conf, builder.createTopology());
		}else{
			LocalCluster cluster = new LocalCluster();
			cluster.submitTopology("Topo", conf, builder.createTopology());
			Utils.sleep(100000);
			cluster.killTopology("Topo");
			cluster.shutdown();
		}
	}
}
