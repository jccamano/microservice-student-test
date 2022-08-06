package com.application.microservice.course.controllers;

import java.util.List;
import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.application.microservice.commons.controllers.CommonController;
import com.application.microservice.commons.students.models.entity.StudentEntity;
import com.application.microservice.course.models.entity.CourseEntity;
import com.application.microservice.course.services.CourseServices;

@RestController
public class CourseController extends CommonController<CourseEntity, CourseServices>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editCourse(@RequestBody CourseEntity course, @PathVariable Long id){
		Optional<CourseEntity> op = this.service.findById(id);
		if(op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		CourseEntity courseDB = op.get();
		courseDB.setName(course.getName());
				
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(courseDB));
	}
	
	@PutMapping("/{id}/assign-students")
	public ResponseEntity<?> assignStudents(@RequestBody List<StudentEntity> students,@PathVariable Long id){
		
		Optional<CourseEntity> op = this.service.findById(id);
		if(op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		CourseEntity courseDB = op.get();
		students.forEach(s -> {
			courseDB.aggStudent(s);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(courseDB));
	}
	
	@PutMapping("/{id}/remove-student")
	public ResponseEntity<?> removeStudent(@RequestBody StudentEntity student,@PathVariable Long id){
		
		Optional<CourseEntity> op = this.service.findById(id);
		if(op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		CourseEntity courseDB = op.get();
		courseDB.removeStudent(student);

		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(courseDB));
	}	
}
