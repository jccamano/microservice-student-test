package com.application.microservice.course.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.application.microservice.commons.controllers.CommonController;
import com.application.microservice.commons.exams.models.entity.ExamsEntity;
import com.application.microservice.commons.students.models.entity.StudentEntity;
import com.application.microservice.course.models.entity.CourseEntity;
import com.application.microservice.course.services.CourseServices;

@RestController
public class CourseController extends CommonController<CourseEntity, CourseServices>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editCourse(@Valid @RequestBody CourseEntity course, BindingResult result ,@PathVariable Long id){
		
		if(result.hasFieldErrors()) {
			return this.validar(result); 
		}		
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
		if(!op.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		CourseEntity courseDB = op.get();
		students.forEach(s -> {
			courseDB.addStudent(s);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(courseDB));
	}
	
	@PutMapping("/{id}/remove-student")
	public ResponseEntity<?> removeStudent(@RequestBody StudentEntity student,@PathVariable Long id){
		
		Optional<CourseEntity> op = this.service.findById(id);
		if(!op.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		CourseEntity courseDB = op.get();
		courseDB.removeStudent(student);

		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(courseDB));
	}
	
	 @GetMapping("/student/{id}") 
	 public ResponseEntity<?> findCourseByStudentId(@PathVariable Long id){ 
		 CourseEntity course = service.findCourseByStudentId(id); 
		 return ResponseEntity.ok(course); }
	 
	 @PutMapping("/{id}/assign-exams")
		public ResponseEntity<?> assignExams(@RequestBody List<ExamsEntity> exams,@PathVariable Long id){
			
			Optional<CourseEntity> op = this.service.findById(id);
			if(!op.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			CourseEntity courseDB = op.get();
			exams.forEach(e -> {
				courseDB.addExam(e);
			});
			return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(courseDB));
		}
		
	 @PutMapping("/{id}/remove-exams")
		public ResponseEntity<?> removeExam(@RequestBody ExamsEntity exam,@PathVariable Long id){
			
			Optional<CourseEntity> op = this.service.findById(id);
			if(!op.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			CourseEntity courseDB = op.get();
			courseDB.removeExam(exam);

			return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(courseDB));
		}
}
