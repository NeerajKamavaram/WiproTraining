package com.Wipro.ConfigServerApp.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController
{
	@Value("${message}")
	private String msg;
	
	@GetMapping("hi")
	public String displayMsg()
	{
		return msg;
	}
}
