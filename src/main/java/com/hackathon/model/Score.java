package com.hackathon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/*CREATE TABLE score(
		id VARCHAR2(20) NOT NULL PRIMARY KEY,
		exam_id varchar2(20) REFERENCES exam(id),
		score INT
	);*/

@Entity
public class Score {
	@Id
	@Column(name="id")
	private String scoreId;
	@OneToOne
	@JoinColumn(name="exam_id")
	private Exam exam;
	private int score;
	public String getScoreId() {
		return scoreId;
	}
	public void setScoreId(String scoreId) {
		this.scoreId = scoreId;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Score() {
		super();
	}
	@Override
	public String toString() {
		return "Score [scoreId=" + scoreId + ", exam=" + exam + ", score=" + score + "]";
	}
	
	 
}
