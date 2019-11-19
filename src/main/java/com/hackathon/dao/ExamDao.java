package com.hackathon.dao;

import java.util.List;

import com.hackathon.model.Question;
import com.hackathon.model.Subject;

public interface ExamDao {
	//method to get all subjects
	public List<Subject> getSubjects();
	
	// method to get all distinct subject names
	public List<String> getSubjectNames();
	
	// method to get subjectid for a particular subject
	public List<String> getSubjectIds(String subjectName);
	
	//method to find difficulty for a particular subject given id
	public String getSubjectLevel(String subjectId);
	
	//check student is eligible for level
	public boolean checkStudent(String subjectLevel);
	
	//method to find examid given studentid and subjectid
	public List<String> findExamId(String studentId,String subjectId);
	
	//method to find score using examId
	public boolean checkScore(String examId);
	
	//method to get questions for a subjectId
	public List<Question> getQuestions(String subjectId);
}
