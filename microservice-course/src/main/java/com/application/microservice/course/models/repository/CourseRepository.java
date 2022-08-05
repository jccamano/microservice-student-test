package com.application.microservice.course.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.application.microservice.course.models.entity.CourseEntity;

public interface CourseRepository extends CrudRepository<CourseEntity, Long>{

}
