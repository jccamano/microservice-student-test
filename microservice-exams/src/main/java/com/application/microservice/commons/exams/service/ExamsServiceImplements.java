package com.application.microservice.commons.exams.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.microservice.commons.exams.models.entity.ExamsEntity;
import com.application.microservice.commons.exams.models.entity.MatterEntity;
import com.application.microservice.commons.exams.models.repository.ExamsRepository;
import com.application.microservice.commons.exams.models.repository.MatterRepository;
import com.application.microservice.commons.services.CommonServiceImplements;

@Service
public class ExamsServiceImplements extends CommonServiceImplements<ExamsEntity, ExamsRepository> implements ExamsService {


	@Autowired
	private MatterRepository matterRepository; 
	
	  @Override	  
	  @Transactional(readOnly = true) public List<ExamsEntity> findByName(String
	  term) { return repository.findByName(term); }

	@Override
	@Transactional(readOnly = true)
	public Iterable<MatterEntity> findAllMatters() {		
		return matterRepository.findAll();
	}

	
}
