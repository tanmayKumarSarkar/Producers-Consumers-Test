package com.kafka.producers.KafkaProducers.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producers.KafkaProducers.model.User;

@Controller
@RestController
@RequestMapping("kafka")
public class UserResource {

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	private static final String TOPIC = "kafka-example";
	
	@GetMapping("/publish/{message}")
	public String postMessage(@PathVariable ("message") final String message) {
		
		kafkaTemplate.send(TOPIC, new User(message, "IT", 120000L));
		return "Published Message" + message; 
	}
}
