package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Training {

	@Id
	private String trainingId;
	private String trainingName;
	private Date startDate;
	private Date endDate;
	
	@ManyToOne
	@JoinColumn(name="student_id")
    private Student student;

	public Training() {
		super();
	}

	public Training(String trainingId, String trainingName, Date startDate, Date endDate, Student student) {
		super();
		this.trainingId = trainingId;
		this.trainingName = trainingName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.student = student;
	}

	public String getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(String trainingId) {
		this.trainingId = trainingId;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Training [trainingId=" + trainingId + ", trainingName=" + trainingName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", student=" + student + "]";
	}

	

}
