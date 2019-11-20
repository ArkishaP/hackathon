package com.hackathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.dao.AdminDaoIntf;
import com.hackathon.model.Admin;
import com.hackathon.model.Subject;
@Service("adminservice")
public class AdminServiceImpl implements AdminServiceIntf {
	
	@Autowired
	private AdminDaoIntf admindao;
	
	public boolean loginAdmin(Admin admin) {
		return admindao.loginAdmin(admin);
	}

	public boolean addSubject(Subject subject) {
		return admindao.addSubject(subject);
	}
	
	

}
