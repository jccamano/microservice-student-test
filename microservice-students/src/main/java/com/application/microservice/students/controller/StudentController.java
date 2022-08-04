package com.application.microservice.students.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.microservice.students.models.entity.StudentEntity;
import com.application.microservice.students.service.StudentServices;


@RestController
@RequestMapping("/")
public class StudentController {
	
	
	@Autowired
	private StudentServices service;
	
	@GetMapping	
	public ResponseEntity<?> getAllStudents(){
		return ResponseEntity.ok().body(service.findAll());		
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Long id){
		
		Optional<StudentEntity> op = service.findById(id);		
		if(op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(op.get());
	}	
	
	@PostMapping
	public ResponseEntity<?> createStudent(@RequestBody StudentEntity student){
		StudentEntity studentDB = service.save(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(studentDB);		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editStudent(@RequestBody StudentEntity student, @PathVariable Long id){
		Optional<StudentEntity> op = service.findById(id);
		if(op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		StudentEntity studentDB = op.get();
		studentDB.setName(student.getName());
		studentDB.setSurname(student.getSurname());
		studentDB.setPhonenumber(student.getPhonenumber());
		studentDB.setEmail(student.getEmail());		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(studentDB));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build(); 
	}

}
