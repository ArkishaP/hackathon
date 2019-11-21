package com.hackathon.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.hackathon.model.Admin;
import com.hackathon.model.Subject;
@Repository("admindao")
public class AdminDaoImpl implements AdminDaoIntf{
	@PersistenceContext
	EntityManager em;
	
	public boolean loginAdmin(Admin admin) {
		boolean flag= false;
		
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
		System.out.println(a);
		return flag;
	}

	public boolean addSubject(Subject subject) {
		boolean flag = false;
		try{
			
			em.persist(subject);
			flag = true;
			}catch(Exception e){
				System.out.println("Error:"+e);
			}
			return flag;
	}

}
