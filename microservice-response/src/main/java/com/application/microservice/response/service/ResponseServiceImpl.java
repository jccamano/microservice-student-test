package com.application.microservice.response.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.microservice.response.models.entity.Respuesta;
import com.application.microservice.response.models.repository.ResponseRepository;

@Service
public class ResponseServiceImpl implements ResponseService {

	private ResponseRepository repository;
	
	@Override
	@Transactional
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {		
		return repository.saveAll(respuestas);
	}

}
