package com.hackathon.service;

import com.hackathon.model.Admin;
import com.hackathon.model.Subject;

public interface AdminServiceIntf {
	
	public boolean loginAdmin(Admin admin);
	public boolean addSubject(Subject subject);

}
