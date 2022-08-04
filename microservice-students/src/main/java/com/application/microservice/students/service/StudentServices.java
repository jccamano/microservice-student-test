package com.application.microservice.students.service;

import java.util.Optional;

import com.application.microservice.students.models.entity.StudentEntity;

public interface StudentServices {
	
    public Iterable<StudentEntity> findAll();
	
	public Optional<StudentEntity> findById(Long id);
	
	public StudentEntity save(StudentEntity student);
	
	public void deleteById(Long id);

}
