package com.hackathon.service;

import com.hackathon.model.Student;

public interface StudentService {
	public boolean registerStudent(Student student);
	public boolean loginStudent(Student student);
//	public boolean changepwd(String studentid,String opwd, String npwd);
}
