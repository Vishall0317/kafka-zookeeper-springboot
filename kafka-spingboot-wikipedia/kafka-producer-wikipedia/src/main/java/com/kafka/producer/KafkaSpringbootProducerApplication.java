package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kafka.producer.service.WikipediaChangesService;

@SpringBootApplication
public class KafkaSpringbootProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSpringbootProducerApplication.class, args);
	}

	@Autowired
	private WikipediaChangesService wikipediaChangesService;

	@Override
	public void run(String... args) throws Exception {
		wikipediaChangesService.sendMessage();
	}

}
