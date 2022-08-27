package com.application.microservice.commons.exams.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "exams")
public class ExamsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String name;

	@Column(name = "creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;	

	@JsonIgnoreProperties(value = { "exams" }, allowSetters = true)
	@OneToMany(mappedBy = "exams", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<QuestionEntity> question;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	private MatterEntity matter;
	
	@PrePersist
	public void creationDate() {
		this.creationDate = new Date();
	}
	
	public ExamsEntity() {
		this.question = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<QuestionEntity> getQuestion() {
		return question;
	}

	public void setQuestion(List<QuestionEntity> question) {
		this.question.clear();
		question.forEach(this::addQuestion);
	}	
	
	public MatterEntity getMatter() {
		return matter;
	}

	public void setMatter(MatterEntity matter) {
		this.matter = matter;
	}

	public void addQuestion(QuestionEntity question) {
		this.question.add(question);
		question.setExams(this);
	}
	
	public void removeQuestion(QuestionEntity question) {
		this.question.remove(question);
		question.setExams(null);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof ExamsEntity)) {
			return false;
		}
		ExamsEntity st = (ExamsEntity) obj;
		
		return this.id != null && this.id.equals(st.getId()); 
	}
	
	
}
