package com.hackathon.service;

import java.util.List;

import com.hackathon.model.Question;
import com.hackathon.model.Subject;

public interface ExamService {
	
	// get distinct subject names
	public List<String> getSubjectNames();
	
	//select subject id
	public String selectSubjectId(String studentId, String subjectName);
	
	//get subject for id
	public Subject getSubject(String subjectId);
/*	
	//method to select level for student returns subjectId
	public String selectExam(String studentId, String subjectName);
	
	//method to return exam id
	public String startExam(String subjectId, String studentId);
	
	//generate questions
	public List<Question> getQuestions(String subjectId);
	
	
	*/
	
}
