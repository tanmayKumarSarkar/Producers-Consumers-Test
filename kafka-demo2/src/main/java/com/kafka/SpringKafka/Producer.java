/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kafka.SpringKafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private final KafkaTemplate<String, Greeting> kafkaTemplate;


    @Value("${cloudkarafka.topic}")
    private String topic;
    
    /*@Bean
    public KafkaTemplate<String, Greeting> greetingKafkaTemplate() {
        return new KafkaTemplate<>(greetingProducerFactory());
    }
    
    @Bean
    public ProducerFactory<String, Greeting> greetingProducerFactory() {
        // ...
        configProps.put(
          ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, 
          JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }*/

    Producer(KafkaTemplate<String, Greeting> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Greeting greet) {
        this.kafkaTemplate.send(topic, greet);
        System.out.println("Sent sample message [" + greet + "] to " + topic);
    }

}
