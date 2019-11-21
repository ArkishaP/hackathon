package com.hackathon.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.hackathon.model.Admin;
import com.hackathon.model.Student;
@Repository("admindao")
public class AdminDaoImpl implements AdminDaoIntf{

	public boolean loginAdmin(Admin admin) {
		boolean flag= false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); 
		EntityManager em = emf.createEntityManager();
		Admin a =null;
		try{
			a=(Admin)em.createQuery("SELECT a FROM Admin a WHERE a.username=:username and a.password=:password")
		         .setParameter("username", admin.getUsername())
		         .setParameter("password",admin.getPassword())
		         .getSingleResult();
		}
		catch(Exception e) {System.out.println(e); }
		if (a!=null)
			flag=true;
		em.persist(a);
		em.close();
		System.out.println(a);
		return flag;
	}

}
