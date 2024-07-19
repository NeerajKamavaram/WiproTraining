package com.Wipro.Student.Controller;

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

import com.Wipro.Student.Entity.StudentEntity;
import com.Wipro.Student.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity studentEntity)
	{
		studentService.saveStudent(studentEntity);
		return new ResponseEntity<>(studentEntity,HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<StudentEntity> getStudentDetails(@PathVariable("id") int studentId)
	{
		StudentEntity studentEntity=studentService.findByStudentId(studentId);
		return new ResponseEntity<>(studentEntity,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<StudentEntity> getAllStudents()
	{
		return studentService.findAll();
	}
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
