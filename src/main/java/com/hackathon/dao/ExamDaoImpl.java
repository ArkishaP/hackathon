package com.hackathon.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.hackathon.model.Exam;
import com.hackathon.model.Question;
import com.hackathon.model.Score;
import com.hackathon.model.Student;
import com.hackathon.model.Subject;

@Repository("examDao")
public class ExamDaoImpl implements ExamDao {
	@PersistenceContext
	EntityManager em;
	
	// get all distinct subject names
	@SuppressWarnings("unchecked")
	public List<String> getSubjectNames() {
		List<String> subjects = new ArrayList<String>();		
		subjects = em.createQuery("Select DISTINCT s.subjectName from Subject s").getResultList();
		return subjects;
	}
	
	//list of subject id order by difficulty
	@SuppressWarnings("unchecked")
	public List<String> getOrderedSubjectIds(String subjectName){
		List<String> subjectIds = new ArrayList<String>();
		subjectIds = em.createQuery("SELECT s.subjectId from Subject s WHERE s.subjectName=:subjectName ORDER BY s.difficulty")
				.setParameter("subjectName", subjectName)
				.getResultList();
		return subjectIds;
		
	}
	
	//get exam id
	public String getExamId(String studentId, String subjectId){
		Student student = em.find(Student.class, studentId);
		Subject subject = em.find(Subject.class, subjectId);
		try{
		String examId = (String) em.createQuery("SELECT e.examId FROM Exam e WHERE e.subject=:subject AND e.student=:student")
				.setParameter("subject", subject)
				.setParameter("student", student)
				.getSingleResult();
		return examId;
		}catch(NoResultException nre){
			
		}
		return "";
	}
	
	//get subject for id
	public Subject getSubject(String subjectId){
		Subject subject = em.find(Subject.class, subjectId);
		return subject;
	}
/*
	// get list of difficulty given a subject name
	@SuppressWarnings("unchecked")
	public List<String> getDifficulty(String subjectName){
		List<String> levels = new ArrayList<String>();
		levels = em.createQuery("SELECT s.difficulty FROM Subject s WHERE s.subjectName=:subjectName ORDER BY s.difficulty")
				.setParameter("subjectName", subjectName)
				.getResultList();
		return levels;
	}
		
	// get subjectid for difficulty
	public String getSubjectId(String difficulty, String subjectName){
		String subjectId = (String)em.createQuery("SELECT s.subjectId FROM Subject s WHERE s.difficulty=:difficulty AND s.subjectName=:subjectName")
			.setParameter("difficulty", difficulty)
			.setParameter("subjectName", subjectName)
			.getSingleResult();
		return subjectId;
	}
	
	//list of exams
	@SuppressWarnings("unchecked")
	public List<Exam> getExams(String studentId, String subjectId) {
		List<Exam> exams = new ArrayList<Exam>();
		Student st = new Student();
		st.setStudentId(studentId);
		Student student = em.find(Student.class, studentId);
		Subject su = new Subject();
		su.setSubjectId(subjectId);
		Subject subject = em.find(Subject.class, subjectId);
		exams = em.createQuery("SELECT e FROM Exam e where e.student=:student AND e.subject=:subject")
				.setParameter("subject", subject)
				.setParameter("student", student).getResultList();
		return exams;
	}
	
	//check score for an exam
		public int getScore(String examId){
			Exam exam = em.find(Exam.class, examId);
			int score = (Integer) em.createQuery("SELECT s.score FROM Score s WHERE s.exam=:exam")
			.setParameter("exam", exam)
			.getSingleResult();
			return score;
		}
	
	//createExam
	public boolean createExam(String studentId, String subjectId){
		boolean flag = false;
		Student student = em.find(Student.class, studentId);
		Subject subject = em.find(Subject.class, subjectId);
		Exam exam = new Exam();
		exam.setStudent(student);
		exam.setSubject(subject);
		try{
			em.persist(exam);
			flag = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return flag;
	}
		
	//get subject
	public Subject getSubject(String subjectId){
		Subject subject = (Subject)em.createQuery("SELECT s from Subject s where s.subjectId=:subjectId")
				.setParameter("subjectId", subjectId)
				.getSingleResult();
		return subject;
	}
		
	//get questions for a subjectId
	@SuppressWarnings("unchecked")
	public List<Question> getQuestions(String subjectId) {
		List<Question> questions = new ArrayList<Question>();	
		Subject subject = new Subject();
		subject.setSubjectId(subjectId);
		questions = em.createQuery("SELECT q from Question q where q.subject=:subject")
				.setParameter("subject", subject).getResultList();	
		return questions;
	
	}
	
	
	
	// -----------------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public List<Subject> getSubjects() {
		List<Subject> subjects = new ArrayList<Subject>();
		
		subjects = em.createQuery("SELECT s from Subject s").getResultList();
		return subjects;
	}

	@SuppressWarnings("unchecked")
	public List<String> getSubjectIds(String subjectName) {
		List<String> subjects = new ArrayList<String>();
		
		subjects = em.createQuery("SELECT s.subjectId FROM Subject s where s.subjectName=:subjectName")
				.setParameter("subjectName", subjectName).getResultList();
		return subjects;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<String> findExamId(String studentId, String subjectId) {
		List<String> exams = new ArrayList<String>();
		
		Student student = new Student();
		student.setStudentId(studentId);
		Subject subject = new Subject();
		subject.setSubjectId(subjectId);
		exams = em.createQuery("SELECT e.examId FROM Exam e where e.student=:student AND e.subject=:subject")
				.setParameter("subject", subject)
				.setParameter("student", student).getResultList();
		return exams;
	}
	
	public String getSubjectLevel(String subjectId) {
		String level;
		
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
		
		
		Exam exam = new Exam();
		exam.setExamId(examId);
		int score = (Integer) em.createQuery("SELECT s.score from Score s WHERE s.exam=:exam")
				.setParameter("exam", exam)
				.getSingleResult();
		if(score>=threshold)
			flag = true;
		return flag;
	}
	
	//number of exams given by student for that subjectid
		public int noOfExams(String studentId, String subjectId){
			int result = (Integer)em.createQuery("SELECT COUNT(e.examId) FROM Exam e WHERE e.studentId=:studentId AND e.subjectId=:subjectId")
					.setParameter("studentId", studentId)
					.setParameter("subjectId", subjectId)
					.getSingleResult();
			return result;
		}

		public Exam getExam(String studentId, String subjectId) {
			Student student = em.find(Student.class, studentId);
			Subject subject = em.find(Subject.class, subjectId);
			Exam exam = (Exam) em.createQuery("SELECT e FROM Exam e where e.student=:student AND e.subject=:subject")
					.setParameter("subject", subject)
					.setParameter("student", student).getSingleResult();
			return exam;
		}
		
*/
}
