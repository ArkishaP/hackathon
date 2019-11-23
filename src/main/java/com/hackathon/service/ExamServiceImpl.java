package com.hackathon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hackathon.dao.ExamDao;
import com.hackathon.model.Exam;
import com.hackathon.model.Question;
import com.hackathon.model.Subject;

@Service("examService")
public class ExamServiceImpl implements ExamService {
	@Autowired
	ExamDao examDao;
	
	@Transactional
	public List<String> getSubjectNames() {
		return examDao.getSubjectNames();
	}
	
	@Transactional
	//select subject id
	public String selectSubjectId(String studentId, String subjectName){
		String subjectId = "";
		List<String> subjectIds = examDao.getOrderedSubjectIds(subjectName);
		for(String sid: subjectIds){
			String examId = examDao.getExamId(studentId, sid);
			if(examId.isEmpty()){
				return sid;
			}
			
		}
		return "";
	}
	
	//get subject for id
	public Subject getSubject(String subjectId){
		return examDao.getSubject(subjectId);
	}
/*	
	@Transactional
	public String selectExam(String studentId, String subjectName){
		String subject = "";
		List<String> difficulties = examDao.getDifficulty(subjectName);
		for(String difficulty:difficulties){
			String subjectId = examDao.getSubjectId(difficulty,subjectName);
			subject = subjectId;
			List<Exam> exams = examDao.getExams(studentId, subjectId);
			if(exams!=null){
			for(Exam exam:exams){
				int score = examDao.getScore(exam.getExamId());
				if(score>65)
					subject = subjectId;
			}
			}else{
				return subjectId;
			}
		}
		return subject;
	}
	
	//method to return exam id
	@Transactional
	public String startExam(String subjectId, String studentId){
		String examId = "";
		Exam exam = examDao.getExam(studentId, subjectId);
		if(exam==null){
			boolean 
		}
		return examId;
	}
	/*@Transactional
	public String selectExam(String studentId, String subjectName) {
		String exam = "";
		List<String> subjectIds = examDao.getSubjectIds(subjectName);
		System.out.println(subjectIds);
		List<String> examIds = new ArrayList<String>();
		for(String subjectId:subjectIds) {
			examIds = examDao.findExamId(studentId, subjectId);
			if(examIds.size()<=0){
				return subjectId;
			}else{
				for(String examId: examIds) {
					if(examDao.checkScore(examId))
						exam = subjectId;
				}
			}
		}
		return exam;
	}

	@Transactional
	public List<Question> getQuestions(String subjectId) {
		return examDao.getQuestions(subjectId);
	}
*/
}
