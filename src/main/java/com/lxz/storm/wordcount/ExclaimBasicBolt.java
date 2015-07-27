package com.lxz.storm.wordcount;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class ExclaimBasicBolt extends BaseBasicBolt{

	public void execute(Tuple input, BasicOutputCollector collector) {
		String sentence = input.getString(0);
		String out = sentence + "!";
		collector.emit(new Values(out));
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("sentence"));
	}
	
}
