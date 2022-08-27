package com.application.microservice.students.controller;

import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.application.microservice.commons.controllers.CommonController;
import com.application.microservice.commons.students.models.entity.StudentEntity;
import com.application.microservice.students.service.StudentServices;


@RestController
public class StudentController extends CommonController<StudentEntity, StudentServices> {
		
	@GetMapping("/uploads/img/{id}")
	public ResponseEntity<?> verFoto(@PathVariable Long id){
		
		Optional<StudentEntity> op = service.findById(id);
		
		if(op.isEmpty() || op.get().getFoto() == null) {
			return ResponseEntity.notFound().build();
		}
		
		Resource imagen = new ByteArrayResource(op.get().getFoto());
		
		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_JPEG)
				.body(imagen);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editStudent(@Valid @RequestBody StudentEntity student, BindingResult result, @PathVariable Long id){
		
		if(result.hasFieldErrors()) {
			return this.validar(result);
		}
		
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

	
	@PostMapping("/crear-con-foto")
	public ResponseEntity<?> createConFoto(@Valid StudentEntity student, BindingResult result, 
			@RequestParam MultipartFile archivo) throws IOException {
		if(!archivo.isEmpty()) {
			student.setFoto(archivo.getBytes());
		}
		return super.createStudent(student, result);
	}
	
	@PutMapping("/editar-con-foto/{id}")
	public ResponseEntity<?> editarConFoto(@Valid StudentEntity student, BindingResult result, 
			@PathVariable Long id, @RequestParam MultipartFile archivo) throws IOException{
		
		if(result.hasFieldErrors()) {
			return this.validar(result);
		}
		
		Optional<StudentEntity> op = service.findById(id);
		if(op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		StudentEntity studentDB = op.get();
		studentDB.setName(student.getName());
		studentDB.setSurname(student.getSurname());
		studentDB.setPhonenumber(student.getPhonenumber());
		studentDB.setEmail(student.getEmail());
		
		if(!archivo.isEmpty()) {
			studentDB.setFoto(archivo.getBytes());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(studentDB));
	}
	

}
