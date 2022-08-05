package com.application.microservice.course.services;

import org.springframework.stereotype.Service;
import com.application.microservice.commons.services.CommonServiceImplements;
import com.application.microservice.course.models.entity.CourseEntity;
import com.application.microservice.course.models.repository.CourseRepository;

@Service
public class CourseServicesImplements extends CommonServiceImplements<CourseEntity, CourseRepository> implements CourseServices {


}
