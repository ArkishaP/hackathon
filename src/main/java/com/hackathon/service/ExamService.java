package com.hackathon.service;

import java.util.List;

import com.hackathon.model.Question;

public interface ExamService {
	// method to get all distinct subject names
	public List<String> getSubjectNames();
	
	//method to select level for student returns subjectId
	public String selectExam(String studentId, String subjectName);
	
	//generate questions
	public List<Question> getQuestions(String subjectId);
}
