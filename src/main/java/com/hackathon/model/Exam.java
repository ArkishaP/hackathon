package com.hackathon.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*CREATE TABLE exam(
		id VARCHAR2(20) NOT NULL PRIMARY KEY,
		student_id VARCHAR2(10) REFERENCES student(id),
		subject_id VARCHAR2(10) REFERENCES subject(id),
		date_of_exam DATE,
		time_taken NUMBER(10)
	);*/

@Entity
public class Exam {
	@Id
	@Column(name="id")
	private String examId;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="subject_id")
	private Subject subject;
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_exam")
	private Date dateOfExam;
	@Column(name="time_taken")
	private int timeTaken;
	
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Date getDateOfExam() {
		return dateOfExam;
	}
	public void setDateOfExam(Date dateOfExam) {
		this.dateOfExam = dateOfExam;
	}
	public int getTimeTaken() {
		return timeTaken;
	}
	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}
	public Exam() {
		super();
	}
	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", student=" + student + ", subject=" + subject + ", dateOfExam=" + dateOfExam
				+ ", timeTaken=" + timeTaken + "]";
	}
	
	
}
