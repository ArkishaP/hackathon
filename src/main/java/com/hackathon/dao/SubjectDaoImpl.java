package com.hackathon.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.hackathon.model.Subject;

@Repository("subjectDao")
public class SubjectDaoImpl implements SubjectDao {

	public List<String> getSubjects() {
List<String> subjects = new ArrayList<String>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		subjects = em.createQuery("SELECT DISTINCT s.subjectName FROM Subject s").getResultList();
		return subjects;
	}

	@SuppressWarnings("unchecked")
	public List<String> getSubjectLevels(String subjectName) {
		List<String> levels = new ArrayList<String>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		String sql = "SELECT s.difficulty FROM Subject s WHERE s.subjectName=:subjectName";
		levels = em.createQuery(sql).setParameter("subjectName",subjectName).getResultList();
		return levels;
	}

}
