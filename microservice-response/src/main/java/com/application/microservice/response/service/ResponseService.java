package com.application.microservice.response.service;

import com.application.microservice.response.models.entity.Respuesta;

public interface ResponseService {
	
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas);

}
