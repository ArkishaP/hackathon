package com.hackathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.dao.StudentDao;
import com.hackathon.model.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;
	
	public boolean registerStudent(Student student) {
		return studentDao.registerStudent(student);
	}

	public boolean loginStudent(Student student) {
		return studentDao.loginStudent(student);
	}

}
