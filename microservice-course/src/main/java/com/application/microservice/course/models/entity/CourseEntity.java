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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.application.microservice.commons.exams.models.entity.ExamsEntity;
import com.application.microservice.commons.students.models.entity.StudentEntity;

@Entity
@Table(name = "courses")
public class CourseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String name;
	
	@Column(name = "creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<StudentEntity> students;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<ExamsEntity> exams;
	
	
	public CourseEntity() {
		this.students = new ArrayList<>();
		this.exams = new ArrayList<>();

	}
	
	@PrePersist
	public void creationDate() {
		this.creationDate = new Date();
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
	
	public void addStudent(StudentEntity student) {
		this.students.add(student);
	}
	
	public void removeStudent(StudentEntity student) {
		
		this.students.remove(student);
	}

	public List<ExamsEntity> getExams() {
		return exams;
	}

	public void setExams(List<ExamsEntity> exams) {
		this.exams = exams;
	}
	
	public void addExam(ExamsEntity exam) {
		this.exams.add(exam);
	}
	
	public void removeExam(ExamsEntity exam) {
		this.exams.remove(exam);
	}
	
}
