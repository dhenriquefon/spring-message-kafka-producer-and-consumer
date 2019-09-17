package io.confluent.developer.kafkaavro;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaAvroApplication {

	@Value("${spring.kafka.topic-name}")
	private String topicName;

	@Value("${spring.kafka.topic.partitions-num}")
	private Integer partitions;

	@Value("${spring.kafka.topic.replication-factor}")
	private short replicationFactor;

	@Bean
	NewTopic moviesTopic() {
		return new NewTopic(topicName, partitions, replicationFactor);
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaAvroApplication.class, args);
	}

}