package com.hackathon.dao;

import java.util.List;

import com.hackathon.model.Exam;
import com.hackathon.model.Question;
import com.hackathon.model.Subject;

public interface ExamDao {
	
	// get all distinct subject names
	public List<String> getSubjectNames();
	
	//list of subject id order by difficulty
	public List<String> getOrderedSubjectIds(String subjectName);
	
	//get exam id
	public String getExamId(String studentId, String subjectId);
	
	//get subject for id
	public Subject getSubject(String subjectId);
	
	/*
	// get list of difficulty given a subject name
	public List<String> getDifficulty(String subjectName);
	
	// get subjectid for difficulty
	public String getSubjectId(String difficulty, String subjectName);

	//list of exams
	public List<Exam> getExams(String studentId, String subjectId);
	
	//get an exam
	public Exam getExam(String studentId, String subjectId);
	
	//check score for an exam
	public int getScore(String examId);
	
	//createExam
	public boolean createExam(String studentId, String subjectId);
	
	//get subject
	public Subject getSubject(String subjectId);
	
	//get questions for a subjectId
	public List<Question> getQuestions(String subjectId);
	
	//---------------------------------------------------------------
	
	//method to find examid given studentid and subjectid
	public List<String> findExamId(String studentId,String subjectId);
	
	//check student is eligible for level
	public boolean checkStudent(String subjectLevel);
	

	//number of exams given by student for that subjectid
	public int noOfExams(String studentId, String subjectId);
	
	//method to find score using examId
	public boolean checkScore(String examId);
	
	
	// method to get subjectid for a particular subject
		public List<String> getSubjectIds(String subjectName);
		
		//method to find difficulty for a particular subject given id
		public String getSubjectLevel(String subjectId);
		
		//method to get all subjects
		public List<Subject> getSubjects();
		*/
}
