package com.Wipro.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Wipro.Model.Course;



@FeignClient(value="COURSE-SERVICE")
public interface CourseApiClient
{
	@GetMapping("/course/get/{id}")
	public Course getCourseDetails(@PathVariable("id") int courseId);


}
