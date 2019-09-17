package io.confluent.developer.kafkaavro.engine;

import io.confluent.developer.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {


    @Value("${spring.kafka.topic-name}")
    private String TOPIC;

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    private final KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user) {
        logger.info(String.format("Produced user -> %s", user.getName()));
        this.kafkaTemplate.send(this.TOPIC, user.getName(), user);
        logger.info(String.format("Produced user -> %s", user));
    }
}