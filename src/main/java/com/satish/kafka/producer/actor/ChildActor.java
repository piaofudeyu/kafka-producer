package com.satish.kafka.producer.actor;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.RecordMetadata;

import scala.util.Random;
import akka.actor.UntypedActor;

import com.satish.kafka.producer.client.IMessageProducer;

public class ChildActor extends UntypedActor {

	IMessageProducer messageProducer;
	
	Random random  =  new Random();
	
	public  ChildActor(IMessageProducer messageProducer) {
		this.messageProducer  =  messageProducer;
	}
	
	@Override
	public void onReceive(Object obj) throws Exception {
		if(obj instanceof String) {  
			int number  = Integer.parseInt((String)obj);
			sendMessage(number);
		} else {
			System.out.println("Ïnvalid Message recieved in child actor");
			
		}
	}
	
	private void sendMessage(int number) {
		String key  = String.valueOf(number+random.nextInt());
		String value  ="{\"value\":\""+ key+ "\"}"; 
		try {
			Future<RecordMetadata> future = messageProducer.sendMessage(key, value);
			RecordMetadata metaData = future.get(30, TimeUnit.SECONDS);
			if(metaData == null) {
				System.out.println("Error in sending message to Kafka Cluster for key :"+ key);
			} else {
				System.out.println("Successfully sent message to Kafka Cluster for key :"+ key+ " , Offset :"+
						metaData.offset()+ " , Partition :"+metaData.partition()+ " , Topic :"+
						metaData.topic());
			}
		} catch(Exception excep){
			System.out.println("Exception in sending message to Kafka Cluster for key :"+ key);
			excep.printStackTrace();
		}
	}
	

}
