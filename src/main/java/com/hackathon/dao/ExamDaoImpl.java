package com.hackathon.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.hackathon.model.Question;
import com.hackathon.model.Subject;

@Repository("examDao")
public class ExamDaoImpl implements ExamDao {
	
	@SuppressWarnings("unchecked")
	public List<Subject> getSubjects() {
		List<Subject> subjects = new ArrayList<Subject>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		subjects = em.createQuery("SELECT s from Subject s").getResultList();
		return subjects;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getSubjectNames() {
		List<String> subjects = new ArrayList<String>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		subjects = em.createQuery("Select DISTINCT s.subjectName from Subject s").getResultList();
		return subjects;
	}

	@SuppressWarnings("unchecked")
	public List<String> getSubjectIds(String subjectName) {
		List<String> subjects = new ArrayList<String>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		subjects = em.createQuery("SELECT s.subjectId FROM Subject s where s.subjectName=:subjectName")
				.setParameter("subjectName", subjectName).getResultList();
		return subjects;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<String> findExamId(String studentId, String subjectId) {
		List<String> exams = new ArrayList<String>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		exams = em.createQuery("SELECT e.examId FROM Exam e where e.studentId=:studentId AND e.subjectId=:subjectId")
				.setParameter("subjectId", subjectId)
				.setParameter("studentId", studentId).getResultList();
		return exams;
	}
	
	public String getSubjectLevel(String subjectId) {
		String level;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		level = (String) em.createQuery("SELECT s.difficulty FROM subject s where s.subjecId=:subjectId")
				.setParameter("subjectId", subjectId).getSingleResult();
		return level;
	}

	public boolean checkStudent(String subjectLevel) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkScore(String examId) {
		boolean flag = false;
		int threshold = 65;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		int score = (Integer) em.createQuery("SELECT s.score from Score s WHERE s.examId=:examId")
				.setParameter("examId", examId)
				.getSingleResult();
		if(score>=threshold)
			flag = true;
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public List<Question> getQuestions(String subjectId) {
		List<Question> questions = new ArrayList<Question>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		questions = em.createQuery("SELECT q from Question where q.subjectId=:subjectId")
				.setParameter("subjectId", subjectId).getResultList();	
		return questions;
	}


}
