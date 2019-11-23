package com.cgi.demo.modify.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaPublisher implements IRecordPublisher<String> {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic-b}")
    String topic;

    @Override
    public void publish(String message) {
        kafkaTemplate.send(topic, message);
    }

}
