package com.satish.kafka.producer.client;

import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.RecordMetadata;

public interface IMessageProducer {

	public Future<RecordMetadata> sendMessage(String key,Object value) ;
}
