package com.lxz.storm.wordcount;

import java.util.Map;
import java.util.Random;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

public class RandomSpout extends BaseRichSpout{
	private SpoutOutputCollector collector;
	private Random rand;
	private static String[] sentences = new String[]{"edi:I'm happy",
			"marry:I'm angry", "john:I'm sad", "ted:I'm exceited", "laden:I'm dangerous"};
	
	public void open(Map conf, TopologyContext context,
			SpoutOutputCollector collector) {
		this.collector = collector;
		this.rand = new Random();
	}
	
	public void nextTuple() {
		String toSay = sentences[rand.nextInt(sentences.length)];
		this.collector.emit(new Values(toSay));
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("sentence"));
	}

}
