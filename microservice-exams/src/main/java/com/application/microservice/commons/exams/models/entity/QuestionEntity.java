package com.application.microservice.commons.exams.models.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "questions")
public class QuestionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String text;
	
	@JsonIgnoreProperties(value = {"question"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id")
	private ExamsEntity exams;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ExamsEntity getExams() {
		return exams;
	}

	public void setExams(ExamsEntity exams) {
		this.exams = exams;
	}
	
}
