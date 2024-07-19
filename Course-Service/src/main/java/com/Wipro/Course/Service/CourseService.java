package com.Wipro.Course.Service;

import java.util.List;

import com.Wipro.Course.Entity.CourseEntity;

public interface CourseService 
{
	CourseEntity saveCourse(CourseEntity courseEntity);
	
	CourseEntity findByCourseId(int courseId);
	
	List<CourseEntity> findAll();

}
