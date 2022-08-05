package com.application.microservice.course.service;

import java.util.Optional;

import com.application.microservice.course.models.entity.CourseEntity;


public interface CourseServices {
	
public Iterable<CourseEntity> findAll();
	
	public Optional<CourseEntity> findById(Long id);
	
	public CourseEntity save(CourseEntity course);
	
	public void deleteById(Long id);

}
