package com.Wipro.Course.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Wipro.Course.Entity.CourseEntity;
import com.Wipro.Course.Exception.ResourseNotFoundException;
import com.Wipro.Course.Repository.CourseRepository;
@Service
public class CourseServiceImpl implements CourseService
{
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public CourseEntity saveCourse(CourseEntity courseEntity) 
	{
		courseRepository.save(courseEntity);
		return courseEntity;
	}

	@Override
	public CourseEntity findByCourseId(int courseId) throws ResourseNotFoundException
	{
		Optional<CourseEntity> optionalCourse=courseRepository.findById(courseId);
		if(optionalCourse.isEmpty())
		{
			throw new ResourseNotFoundException("course not found with id: "+courseId);
		}
		CourseEntity courseEntity=optionalCourse.get();
		return courseEntity;
	}

	@Override
	public List<CourseEntity> findAll() 
	{
		return courseRepository.findAll();
	}

}
