package com.satish.kafka.producer.actor;

import com.satish.kafka.producer.client.IMessageProducer;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;


public class ParentActor extends UntypedActor{
	
	ActorRef childActor  = null;
	
	ParentActor(IMessageProducer messageProducer)  {
		childActor   = this.getContext().actorOf(Props.create(ChildActor.class,messageProducer), "child");
	}
	
	@Override
	public void onReceive(Object arg0) throws Exception {
		this.childActor.tell(arg0, getSelf());
	}
	
}
