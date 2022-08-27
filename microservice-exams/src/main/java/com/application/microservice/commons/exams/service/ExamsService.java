package com.application.microservice.commons.exams.service;

import java.util.List;

import com.application.microservice.commons.exams.models.entity.ExamsEntity;
import com.application.microservice.commons.exams.models.entity.MatterEntity;
import com.application.microservice.commons.exams.models.repository.MatterRepository;
import com.application.microservice.commons.services.CommonService;

public interface ExamsService extends CommonService<ExamsEntity>{
	
	public List<ExamsEntity> findByName(String term);
	
	public Iterable<MatterEntity> findAllMatters();
}
