package com.hackathon.dao;

import com.hackathon.model.Admin;
import com.hackathon.model.Subject;

public interface AdminDaoIntf {
	public boolean loginAdmin(Admin admin);
	public boolean addSubject(Subject subject);

}
