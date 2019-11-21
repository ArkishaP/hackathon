package com.hackathon.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.hackathon.model.Student;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {
	@PersistenceContext
	EntityManager em;
	
	public boolean registerStudent(Student student) {
		boolean flag = false;
		try{
			em.persist(student);
			flag = true;
//			System.out.println("Student called");
			}catch(Exception e){
				System.out.println("Error:"+e);
			}
			return flag;
	}

	public boolean loginStudent(Student student) {
		boolean flag= false;
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
		System.out.println(s);
		return flag;
	}

}
