package com.application.microservice.course.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.application.microservice.course.models.entity.CourseEntity;

public interface CourseRepository extends CrudRepository<CourseEntity, Long>{

	@Query("select c from CourseEntity c join fetch c.students s where s.id=?1")
	public CourseEntity findCourseByStudentId(Long id);
}
