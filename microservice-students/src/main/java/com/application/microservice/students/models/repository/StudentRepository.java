package com.application.microservice.students.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.application.microservice.commons.students.models.entity.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Long>{

}
