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

	/*public boolean changepwd(String studentid,String opwd, String npwd) {
		  boolean flag=false;
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		  EntityManager em = emf.createEntityManager();	  
		  Query query = em.createQuery("update Student u set u.password=:npwd where u.studentid=:studentid and u.password=:opwd");
		  query.setParameter("npwd", npwd);
		  query.setParameter("opwd", opwd);
		  query.setParameter("studentid", studentid);
		  em.getTransaction().begin();
		  int r = query.executeUpdate();
		  em.getTransaction().commit();
		  em.close();
		  if(r>0)
			  flag=true;
		  return flag;
	  }*/
}
