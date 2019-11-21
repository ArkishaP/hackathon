package com.hackathon.dao;

import com.hackathon.model.Student;

public interface StudentDao {
	public boolean registerStudent(Student student);
	public boolean loginStudent(Student student);
//	public boolean changepwd(String studentid,String opwd, String npwd);
}
