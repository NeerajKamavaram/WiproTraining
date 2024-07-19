package com.Wipro.Student.Service;

import java.util.List;

import com.Wipro.Student.Entity.StudentEntity;

public interface StudentService 
{
	StudentEntity saveStudent(StudentEntity studentEntity);
	
	StudentEntity findByStudentId(int studentId);
	
	List<StudentEntity> findAll();

}
