package com.application.microservice.students.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.microservice.commons.controllers.CommonController;
import com.application.microservice.commons.students.models.entity.StudentEntity;
import com.application.microservice.students.service.StudentServices;


@RestController
public class StudentController extends CommonController<StudentEntity, StudentServices> {
		
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
	
	@GetMapping("/search-by-first-or-last-name/{term}")
	public ResponseEntity<?> searchByFirstOrLastName (@PathVariable String term){
		return ResponseEntity.ok(service.findByNameOrSurname(term));
	}

}
