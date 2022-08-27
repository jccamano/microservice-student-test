package com.application.microservice.response.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.application.microservice.response.models.entity.Respuesta;

public interface ResponseRepository extends CrudRepository<Respuesta, Long>{

}
