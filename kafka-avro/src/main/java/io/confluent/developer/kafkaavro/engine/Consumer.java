package io.confluent.developer.kafkaavro.engine;

import io.confluent.developer.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class Consumer {



    @Value("${spring.kafka.topic-name}")
    private String topicName;
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(ConsumerRecord<String, User> record) {
        logger.info(String.format("Consumed message -> %s", record.value()));
    }
}