package com.learning.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	
	@Bean
	public NewTopic firstTopic() {
		return TopicBuilder.name("firstTopic").build();
	}
	
	@Bean
	public NewTopic secondTopic() {
		return TopicBuilder.name("secondTopic").partitions(10).build();
	}

	@Bean
	public NewTopic firstJsonTopic() {
		return TopicBuilder.name("firstJsonTopic").build();
	}
}
