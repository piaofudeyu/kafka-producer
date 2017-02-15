package com.satish.kafka.producer.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import com.satish.kafka.producer.client.IMessageProducer;

public class ActorHandlerImpl implements ActorHandlerIF {

	private IMessageProducer messageProducer;
	
	private ActorSystem actorSystem  = null;
	
	private ActorRef parentActor  = null;
	
	public ActorHandlerImpl (String actorName,IMessageProducer messageProducer) {
		this.messageProducer =  messageProducer;
		actorSystem = ActorSystem.create(actorName);
		createActor();
	}
	
	private void createActor() {
		parentActor = actorSystem.actorOf(Props.create(ParentActor.class,messageProducer), "parent");
	}
	
	public void sendMessage(String message) {
		this.parentActor.tell(message, parentActor);
	}
	
}
