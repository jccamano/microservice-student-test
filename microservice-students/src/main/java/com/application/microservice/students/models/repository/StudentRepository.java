package com.application.microservice.students.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.application.microservice.commons.students.models.entity.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Long>{
	
	@Query("select s from StudentEntity s where s.name like %?1% or s.surname like %?1%")
	public List<StudentEntity> findByNameOrSurname(String term);

}
