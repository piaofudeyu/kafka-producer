package com.satish.kafka.producer.client;

import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class MessageProducer implements IMessageProducer {

	private Producer<String,Object> producer;
	
	private String topicName;
	
	
	public MessageProducer(Producer<String,Object> producer,String topicName) 
	{
		this.producer  = producer;
		this.topicName  = topicName;
	}
	
	public Future<RecordMetadata> sendMessage(String key,Object value) 
	{
		ProducerRecord<String, Object> record   = new ProducerRecord<String, Object>(topicName, key, value);
		Future<RecordMetadata> future =  this.producer.send(record);
		return future;
	}
}
