package com.application.microservice.students.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.microservice.students.models.entity.StudentEntity;
import com.application.microservice.students.models.repository.StudentRepository;

@Service
public class StudentServicesImplements implements StudentServices {

	@Autowired
	private StudentRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<StudentEntity> findAll() {		
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<StudentEntity> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public StudentEntity save(StudentEntity student) {
		
		return repository.save(student);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
