package com.hackathon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.dao.SubjectDao;
import com.hackathon.model.Subject;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	SubjectDao subjectDao;
	public List<String> getSubjects() {
		return subjectDao.getSubjects();
	}
	public List<String> getSubjectLevels(String subjectName) {
		List<String> rawLevels = new ArrayList<String>();
//		for(String level:rawLevels){
//			if(level)
//		}
		return null;
	}

}
