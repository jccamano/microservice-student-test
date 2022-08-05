package com.application.microservice.students.service;




import org.springframework.stereotype.Service;


import com.application.microservice.commons.services.CommonServiceImplements;
import com.application.microservice.students.models.entity.StudentEntity;
import com.application.microservice.students.models.repository.StudentRepository;

@Service
public class StudentServicesImplements extends CommonServiceImplements<StudentEntity, StudentRepository> implements StudentServices {

}
