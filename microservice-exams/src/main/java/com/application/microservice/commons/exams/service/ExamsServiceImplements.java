package com.application.microservice.commons.exams.service;


import org.springframework.stereotype.Service;

import com.application.microservice.commons.exams.models.entity.ExamsEntity;
import com.application.microservice.commons.exams.models.repository.ExamsRepository;
import com.application.microservice.commons.services.CommonServiceImplements;

@Service
public class ExamsServiceImplements extends CommonServiceImplements<ExamsEntity, ExamsRepository> implements ExamsService {

	
}
