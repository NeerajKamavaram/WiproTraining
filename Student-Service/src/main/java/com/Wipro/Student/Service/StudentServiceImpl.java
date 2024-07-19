package com.Wipro.Student.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Wipro.Student.Entity.StudentEntity;
import com.Wipro.Student.Exception.ResourseNotFoundException;
import com.Wipro.Student.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public StudentEntity saveStudent(StudentEntity studentEntity) 
	{
		studentRepository.save(studentEntity);
		return studentEntity;
	}

	@Override
	public StudentEntity findByStudentId(int studentId) throws ResourseNotFoundException
	{
		Optional<StudentEntity> optionalStudent=studentRepository.findById(studentId);
		if(optionalStudent.isEmpty())
		{
			throw new ResourseNotFoundException("student not found with id: "+studentId);
		}
		StudentEntity studentEntity=optionalStudent.get();
		return studentEntity;
	}

	@Override
	public List<StudentEntity> findAll()
	{
		return studentRepository.findAll();
	}

}
