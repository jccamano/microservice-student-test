package com.application.microservice.students.service;




import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.microservice.commons.services.CommonServiceImplements;
import com.application.microservice.commons.students.models.entity.StudentEntity;
import com.application.microservice.students.models.repository.StudentRepository;

@Service
public class StudentServicesImplements extends CommonServiceImplements<StudentEntity, StudentRepository> implements StudentServices {

	@Override
	@Transactional(readOnly = true)
	public List<StudentEntity> findByNameOrSurname(String term) {		
		return repository.findByNameOrSurname(term);
	}

}
