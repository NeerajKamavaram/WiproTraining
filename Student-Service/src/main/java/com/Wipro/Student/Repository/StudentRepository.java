package com.Wipro.Student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Wipro.Student.Entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>
{

}
