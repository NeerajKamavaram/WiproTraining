package com.Wipro.SpringSecurityDemo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController
{
	@GetMapping("/test")
	public ResponseEntity<String> testMethod()
	{
		String title="Security Demo App";
		return new ResponseEntity<>(title,HttpStatus.OK);
	}
}
