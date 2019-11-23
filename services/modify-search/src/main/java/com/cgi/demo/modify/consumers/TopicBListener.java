package com.cgi.demo.modify.consumers;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TopicBListener implements IRecordConsumer<ConsumerRecord<?, ?>> {

    private Logger LOG = LoggerFactory.getLogger(TopicBListener.class);

    @KafkaListener(topics = "${kafka.topic-b}", groupId = "test-group")
    public boolean listen(ConsumerRecord<?, ?> cr) {

        try {
            String value = (String)cr.value();
            LOG.info("Message Received by Topic Youtube Modify {}", value);
        } catch (Exception e) {
            LOG.error("Exception {}", e);
            return false;
        }
        return true;
    }
}
