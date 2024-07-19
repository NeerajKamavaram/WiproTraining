package com.Wipro.Course.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Wipro.Course.Entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer>
{

}
