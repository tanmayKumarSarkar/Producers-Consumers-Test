package com.kafka.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.core.Sender;
import com.kafka.model.Car;

@Controller
@RestController
@RequestMapping("kafka")
public class MessageProducer {

//	@Autowired
//	private KafkaTemplate<String, Car> kafkaTemplate;
//	private static final String TOPIC = "kafka-example";
	
	@Autowired
	private Sender sender;
	
	@GetMapping("/publish/{message}")
	public String postMessage(@PathVariable ("message") final String message) {
		
		Car car = new Car(message, "Volkswagen", "ABC-123");
	    sender.send(car);
		
		//kafkaTemplate.send(TOPIC, new User(message, "IT", 120000L));
		return "Published Message" + message; 
	}
}