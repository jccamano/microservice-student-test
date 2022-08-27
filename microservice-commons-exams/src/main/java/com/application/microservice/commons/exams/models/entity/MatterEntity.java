package com.application.microservice.commons.exams.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "matters")
public class MatterEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@JsonIgnoreProperties(value = {"daughterMatter"})
	@ManyToOne(fetch = FetchType.LAZY)
	private MatterEntity parentMatter;
	
	@JsonIgnoreProperties(value = {"parentMatter"}, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parentMatter", cascade = CascadeType.ALL)
	private List<MatterEntity> daughterMatter;
	
	public MatterEntity() {
		this.daughterMatter = new ArrayList<>();
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

	public MatterEntity getParentMatter() {
		return parentMatter;
	}

	public void setParentMatter(MatterEntity parentMatter) {
		this.parentMatter = parentMatter;
	}

	public List<MatterEntity> getDaughterMatter() {
		return daughterMatter;
	}

	public void setDaughterMatter(List<MatterEntity> daughterMatter) {
		this.daughterMatter = daughterMatter;
	}	
}
