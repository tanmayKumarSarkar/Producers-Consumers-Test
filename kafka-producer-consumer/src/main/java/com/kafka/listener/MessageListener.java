package com.kafka.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.stereotype.Service;

import com.kafka.core.Receiver;
import com.kafka.model.Car;

@Service
public class MessageListener {

	
	@Autowired
	private Receiver receiver;
	
	@Autowired
	private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;
	
	  /*@ClassRule
	  public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, "json.t");
	
	  @Before
	  public void setUp() throws Exception {
	    // wait until the partitions are assigned
	    for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
	        .getListenerContainers()) {
	      ContainerTestUtils.waitForAssignment(messageListenerContainer,
	          embeddedKafka.getPartitionsPerTopic());
	    }
	  }*/
	
	
//	@KafkaListener(topics = "kafka-example", groupId = "group_id")
//	public void consume (String message) {
//		System.out.println("Consumed message : "+message);
//	}
//	
//	@KafkaListener(topics = "kafka-example-m", groupId = "group_json")
//    public void consumeJson(Car user) {
//        System.out.println("Consumed JSON Message: " + user);
//    }
}
