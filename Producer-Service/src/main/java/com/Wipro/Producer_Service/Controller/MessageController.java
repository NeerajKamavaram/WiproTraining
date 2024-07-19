package com.Wipro.Producer_Service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Wipro.Producer_Service.Service.KafkaMessageProducer;

@RestController
@RequestMapping("/api")
public class MessageController 
{
	@Autowired
	private KafkaMessageProducer kafkaProducer;
	
	
	@GetMapping("/send/{msg}")
	public ResponseEntity<String> produceMessage(@PathVariable("msg") String msg) 
	{
		kafkaProducer.sendMessage(msg);
		return new ResponseEntity<>("message sent to server",HttpStatus.CREATED);
	}

}
