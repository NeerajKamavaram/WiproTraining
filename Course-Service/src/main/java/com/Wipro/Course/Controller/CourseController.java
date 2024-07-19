package com.Wipro.Course.Controller;

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

import com.Wipro.Course.Entity.CourseEntity;
import com.Wipro.Course.Service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController 
{
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/save")
	public ResponseEntity<CourseEntity> createCourse(@RequestBody CourseEntity courseEntity)
	{
		courseService.saveCourse(courseEntity);
		return new ResponseEntity<>(courseEntity,HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CourseEntity> getCourseDetails(@PathVariable("id") int studentId)
	{
		CourseEntity studentEntity=courseService.findByCourseId(studentId);
		return new ResponseEntity<>(studentEntity,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<CourseEntity> getAllCourses()
	{
		return courseService.findAll();
	}
}
