package com.satish.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.satish.kafka.producer.actor.ActorHandlerIF;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner
{
	@Autowired
	ActorHandlerIF actorHandler;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProducerApplication.class, args);
		
		
		
		
		
	}
	
	private void process() {
		for(int i = 0;i<5;i++){
			actorHandler.sendMessage(i+"");
		}	
	}

	@Override
	public void run(String... arg0) throws Exception {
		process();
	}
}
