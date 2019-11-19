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

	public List<Subject> getSubjects() {
		List<Subject> subjects = new ArrayList<Subject>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		subjects = em.createQuery("SELECT s FROM Subject s").getResultList();
		return subjects;
	}

}
