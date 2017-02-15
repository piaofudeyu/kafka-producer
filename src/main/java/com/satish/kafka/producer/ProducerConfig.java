package com.satish.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.satish.kafka.producer.actor.ActorHandlerIF;
import com.satish.kafka.producer.actor.ActorHandlerImpl;
import com.satish.kafka.producer.client.IMessageProducer;
import com.satish.kafka.producer.client.MessageProducer;

@Configuration
public class ProducerConfig {

	@Autowired
	ProducerProperties props;
	
	@Bean
	public Producer<String,Object> getKafkaProducer(){
	//	Map<String,Object> configs = new HashMap<String,Object>();
	//	System.out.println(props.getProducerConfig() );
		/*configs.put("bootstrap.servers",props.getBootstrapServers() );
		configs.put("key.serializer",props.getKeySerializer() );
		configs.put("value.serializer",props.getValueSerializer());
		configs.put("acks",props.getAcks());
		configs.put("buffer.memory",props.getBufferMemory());
		configs.put("compression.type",props.getCompressionType());
		configs.put("retries",props.getRetries());
		configs.put("batch.size",props.getBatchSize());
		configs.put("client.id",props.getClientId());
		configs.put("connections.max.idle.ms",props.getConnectionsMaxIdleMs());
		configs.put("linger.ms",props.getLingerMs());*/
		Producer<String,Object> producer  = new KafkaProducer<String, Object>(props.getProducerConfig());
		return producer;
	}
	
	@Bean
	public IMessageProducer getMessageProducer() {
		return new MessageProducer(getKafkaProducer(),props.getTopciName());
	}
	
	@Bean
	public ActorHandlerIF getActorHandler() {
		return new ActorHandlerImpl("myActorSystem",getMessageProducer());
	}
	
}
