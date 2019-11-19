package com.hackathon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.dao.ExamDao;
import com.hackathon.model.Question;

@Service("examService")
public class ExamServiceImpl implements ExamService {
	@Autowired
	ExamDao examDao;
	
	public List<String> getSubjectNames() {
		return examDao.getSubjectNames();
	}

	public String selectExam(String studentId, String subjectName) {
		String exam = null;
		List<String> subjectIds = examDao.getSubjectIds(subjectName);
		List<String> examIds = new ArrayList<String>();
		for(String subjectId:subjectIds) {
			examIds = examDao.findExamId(studentId, subjectId);
			for(String examId: examIds) {
				if(examDao.checkScore(examId))
					exam = subjectId;
			}
		}
		return exam;
	}

	public List<Question> getQuestions(String subjectId) {
		return examDao.getQuestions(subjectId);
	}

}