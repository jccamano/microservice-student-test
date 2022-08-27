package com.application.microservice.response.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.microservice.response.models.entity.Respuesta;
import com.application.microservice.response.service.ResponseService;

@RestController
public class ResponseController {
	
	@Autowired
	private ResponseService service;
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Iterable<Respuesta> respuestas ){
		Iterable<Respuesta> respuestasDB = service.saveAll(respuestas);
		return ResponseEntity.status(HttpStatus.CREATED).body(respuestasDB);
	}

}
