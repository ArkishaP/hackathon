package com.hackathon.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*CREATE TABLE subject(
		id VARCHAR2(4) NOT NULL PRIMARY KEY,
		name VARCHAR2(50),
		difficulty VARCHAR2(2),
		duration NUMBER(3),
		question_file VARCHAR2(200)
	);*/

@Entity
public class Subject {
	@Id
	@Column(name="id")
	private String subjectId;
	@Column(name="name")
	private String subjectName;
	private String difficulty;
	private int duration;
	@Column(name="question_file")
	private String questionFile;
	
	@OneToMany(mappedBy="subject",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Question> questions = new ArrayList<Question>();

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public String getQuestionFile() {
		return questionFile;
	}

	public void setQuestionFile(String questionFile) {
		this.questionFile = questionFile;
	}

	public Subject() {
		super();
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", difficulty=" + difficulty
				+ ", duration=" + duration + ", questionFile=" + questionFile + ", questions=" + questions + "]";
	}

	
	
}
