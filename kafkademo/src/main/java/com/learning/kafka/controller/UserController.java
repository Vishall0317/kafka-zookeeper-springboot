package com.learning.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.kafka.model.User;
import com.learning.kafka.producer.JsonKafkaProducer;

@RestController
@RequestMapping("/api/kafka")
public class UserController {
	
	@Autowired
	private JsonKafkaProducer jsonKafkaProducer;
	
	@PostMapping("/publish/user")
	public ResponseEntity<String> publish(@RequestBody User user){
		jsonKafkaProducer.sendUser(user);
		return ResponseEntity.ok("user data send to the topic");
	}

}
