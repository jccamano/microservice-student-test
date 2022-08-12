package com.application.microservice.course.services;

import com.application.microservice.commons.services.CommonService;
import com.application.microservice.course.models.entity.CourseEntity;


public interface CourseServices extends CommonService<CourseEntity>{
	
	public CourseEntity findCourseByStudentId(Long id);
}
