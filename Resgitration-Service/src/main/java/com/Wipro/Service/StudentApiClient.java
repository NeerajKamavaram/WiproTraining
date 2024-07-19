package com.Wipro.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Wipro.Model.Student;

@FeignClient(value="STUDENT-SERVICE")
public interface StudentApiClient
{
	@GetMapping("/student/get/{id}")
	public Student getStudentDetails(@PathVariable("id") int studentId);
}
