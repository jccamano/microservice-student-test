package com.application.microservice.commons.exams.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.application.microservice.commons.exams.models.entity.ExamsEntity;

public interface ExamsRepository extends CrudRepository<ExamsEntity, Long>{

}
