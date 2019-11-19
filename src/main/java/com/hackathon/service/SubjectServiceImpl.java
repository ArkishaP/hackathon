package com.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.dao.SubjectDao;
import com.hackathon.model.Subject;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	SubjectDao subjectDao;
	public List<Subject> getSubjects() {
		return subjectDao.getSubjects();
	}

}
