package com.application.microservice.commons.exams.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.application.microservice.commons.exams.models.entity.MatterEntity;

public interface MatterRepository extends CrudRepository<MatterEntity, Long>{

}
