package com.application.microservice.commons.controllers;

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

import com.application.microservice.commons.services.CommonService;

public class CommonController<E, S extends CommonService<E>> {
	
	
	@Autowired
	protected S service;
	
	@GetMapping	
	public ResponseEntity<?> getAllStudents(){
		return ResponseEntity.ok().body(service.findAll());		
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Long id){
		
		Optional<E> op = service.findById(id);		
		if(op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(op.get());
	}	
	
	@PostMapping
	public ResponseEntity<?> createStudent(@RequestBody E entity){
		E entityDB = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityDB);		
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build(); 
	}

}
