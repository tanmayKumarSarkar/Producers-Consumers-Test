package com.kafka.core;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import com.kafka.model.Car;


public class Receiver {

  private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

  private CountDownLatch latch = new CountDownLatch(1);
  
  private final String jsonTopic = "kafka-example";

  public CountDownLatch getLatch() {
    return latch;
  }

  @KafkaListener(topics = jsonTopic)
  public void receive(Car car) {
    LOGGER.info("received car='{}'", car.toString());
    latch.countDown();
  }
}