package com.application.microservice.commons.exams.controller;


import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.microservice.commons.controllers.CommonController;
import com.application.microservice.commons.exams.models.entity.ExamsEntity;
import com.application.microservice.commons.exams.service.ExamsService;

@RestController
public class ExamsController extends CommonController<ExamsEntity, ExamsService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editExams(@RequestBody ExamsEntity exams, @PathVariable Long id){
		
		Optional<ExamsEntity> op = service.findById(id);
		
		if(!op.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		ExamsEntity examsDb = op.get();
		examsDb.setName(exams.getName());		
		
		examsDb.getQuestion()
		.stream()
		.filter(pdb -> !exams.getQuestion().contains(pdb))		
		.forEach(examsDb::removeQuestion);
		
		examsDb.setQuestion(exams.getQuestion());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examsDb));
		
	}

}
