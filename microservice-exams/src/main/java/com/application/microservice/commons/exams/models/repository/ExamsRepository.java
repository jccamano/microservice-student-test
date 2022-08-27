package com.application.microservice.commons.exams.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.application.microservice.commons.exams.models.entity.ExamsEntity;

public interface ExamsRepository extends PagingAndSortingRepository<ExamsEntity, Long>{	
	
	  @Query("select e from ExamsEntity e where e.name like %?1%") 
	  public List<ExamsEntity> findByName(String term);	 

}
