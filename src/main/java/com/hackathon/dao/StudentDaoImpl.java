package com.hackathon.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.hackathon.model.Student;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

	public boolean registerStudent(Student student) {
		boolean flag = false;
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); 
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(student);
			em.getTransaction().commit();
			em.close();
			flag = true;
//			System.out.println("Student called");
			}catch(Exception e){
				System.out.println("Error:"+e);
			}
			return flag;
	}

	public boolean loginStudent(Student student) {
		boolean flag= false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); 
		EntityManager em = emf.createEntityManager();
		Student s =null;
		try{
			s=(Student)em.createQuery("SELECT s FROM Student s WHERE s.studentId=:id and s.password=:pwd")
		         .setParameter("id", student.getStudentId())
		         .setParameter("pwd",student.getPassword())
		         .getSingleResult();
		}
		catch(Exception e) {System.out.println(e); }
		if (s!=null)
			flag=true;
		em.close();
		System.out.println(s);
		return flag;
	}

}
