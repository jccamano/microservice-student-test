package com.application.microservice.course.controller;

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

import com.application.microservice.course.models.entity.CourseEntity;
import com.application.microservice.course.service.CourseServices;


@RestController
@RequestMapping("/")
public class CourseController {
	
	@Autowired
	private CourseServices service;
	
	@GetMapping	
	public ResponseEntity<?> getAllCourses(){
		return ResponseEntity.ok().body(service.findAll());		
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<?> getCoursetById(@PathVariable Long id){
		
		Optional<CourseEntity> op = service.findById(id);		
		if(op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(op.get());
	}	
	
	@PostMapping
	public ResponseEntity<?> createCourse(@RequestBody CourseEntity course){
		CourseEntity courseDB = service.save(course);
		return ResponseEntity.status(HttpStatus.CREATED).body(courseDB);		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editCourse(@RequestBody CourseEntity course, @PathVariable Long id){
		Optional<CourseEntity> op = service.findById(id);
		if(op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		CourseEntity courseDB = op.get();
		courseDB.setName(course.getName());
				
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(courseDB));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCourse(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build(); 
	}
	

}
