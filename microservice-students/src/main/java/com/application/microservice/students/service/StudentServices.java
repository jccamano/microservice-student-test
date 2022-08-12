package com.application.microservice.students.service;


import java.util.List;

import com.application.microservice.commons.services.CommonService;
import com.application.microservice.commons.students.models.entity.StudentEntity;

public interface StudentServices extends CommonService<StudentEntity>{
	
	public List<StudentEntity> findByNameOrSurname(String term);

}
