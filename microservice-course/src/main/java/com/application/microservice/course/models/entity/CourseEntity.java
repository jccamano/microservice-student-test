package com.application.microservice.course.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.application.microservice.commons.students.models.entity.StudentEntity;

@Entity
@Table(name = "courses")
public class CourseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(name = "creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<StudentEntity> students;
	
	
	@PrePersist
	public void creationDate() {
		this.creationDate = new Date();
	}
	
	public CourseEntity() {
		this.students = new ArrayList<>();

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

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}
	
	public void aggStudent(StudentEntity student) {
		this.students.add(student);
	}
	
	public void removeStudent(StudentEntity student) {
		
		this.students.remove(student);
	}

}
