package com.cgi.demo.modify.consumers;

import com.cgi.demo.modify.service.ModifyAndSendService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TopicAListener implements IRecordConsumer<ConsumerRecord<?, ?>> {

    private Logger LOG = LoggerFactory.getLogger(TopicAListener.class);

    @Autowired
    ModifyAndSendService sendService;

    @KafkaListener(topics = "${kafka.topic-a}", groupId = "test-group")
    public boolean listen(ConsumerRecord<?, ?> cr) {

       try {
           String value = (String)cr.value();
           LOG.info("Message Received by Youtube search topic {}", value);
           sendService.transformAndSend(value);
       } catch (Exception e) {
           LOG.error("Exception {}", e);
           return false;
       }
       return true;
    }
}
