package com.hackathon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/*CREATE TABLE answer(
		id VARCHAR2(20) NOT NULL PRIMARY KEY,
		exam_id varchar2(20) REFERENCES exam(id),
		question_id varchar2(20) REFERENCES question(id),
		response VARCHAR2(500),
		correct VARCHAR2(10)
	);*/

@Entity
public class Answer {
	@Id
	@Column(name="id")
	private String answerId;
	@ManyToOne
	@JoinColumn(name="exam_id")
	private Exam exam;
	@OneToOne
	@JoinColumn(name="question_id")
	private Question question;
	private String response;
	private String correct;
	public Answer() {
		super();
	}
	public String getAnswerId() {
		return answerId;
	}
	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getCorrect() {
		return correct;
	}
	public void setCorrect(String correct) {
		this.correct = correct;
	}
	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", exam=" + exam + ", question=" + question + ", response=" + response
				+ ", correct=" + correct + "]";
	}
	
	

}
