package com.kafka.Consumers.KafkaConsumers.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.Consumers.KafkaConsumers.model.User;

@Service
public class KafkaConsumerListener {

	@KafkaListener(topics = "kafka-example-text", groupId = "group_id")
	public void consume (String message) {
		System.out.println("Consumed message : "+message);
	}
	
//	@KafkaListener(topics = "kafka_example", groupId = "group_user"/*, containerFactory = "userKafkaListenerContainerFactory"*/)
//	public void consumeJSON(User user) {
//		System.out.println("Consumed user : "+user);
//	}
	
	@KafkaListener(topics = "kafka-example", groupId = "group_json")
    public void consumeJson(User user) {
        System.out.println("Consumed JSON Message: " + user);
    }
}
