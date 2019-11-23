package com.cgi.demo.search.publisher;

import com.cgi.demo.search.service.YoutubeModel;
import com.cgi.demo.search.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaPublisher implements IRecordPublisher<YoutubeModel> {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic}")
    String topic;

    @Override
    public void publish(YoutubeModel message) {
        String xmlString = Utils.createXmlMessage(message.getUrl(), message.getTitle());
        kafkaTemplate.send(topic, xmlString);
    }

}
