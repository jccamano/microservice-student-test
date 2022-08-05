package com.application.microservice.course.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.microservice.course.models.entity.CourseEntity;
import com.application.microservice.course.models.repository.CourseRepository;

@Service
public class CourseServicesImplements implements CourseServices {

	@Autowired
	private CourseRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<CourseEntity> findAll() {		
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<CourseEntity> findById(Long id) {		
		return repository.findById(id);
	}

	@Override
	@Transactional
	public CourseEntity save(CourseEntity course) {
		
		return repository.save(course);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

}
