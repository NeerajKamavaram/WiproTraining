package com.Wipro.ConfigServerApp.Controller;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController 
{
	@Value("${message}")
	private String msg;
	
	@GetMapping("/hello")
	public String displayMsg()
	{
		return msg;
	}
}
