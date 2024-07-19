package com.Wipro.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Wipro.Entity.RegistrationEntity;
import com.Wipro.Model.Course;
import com.Wipro.Model.Registration;
import com.Wipro.Service.RegistrationService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/registration")
public class RegistrationController 
{
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/save")
	public ResponseEntity<RegistrationEntity> doRegistration(@RequestBody RegistrationEntity registrationEntity)
	{
		registrationService.register(registrationEntity);
		return new ResponseEntity<>(registrationEntity,HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Registration> getRegistrationDetails(@PathVariable("id") int registrationId)
	{
		Registration registration=registrationService.getRegistrationDetailsById(registrationId);
		return new ResponseEntity<>(registration,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<Registration> getAllRegistrations()
	{
		return registrationService.findAllRegistrations();
	}
	
}
