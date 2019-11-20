package com.hackathon.dao;

import java.util.List;

import com.hackathon.model.Subject;

public interface SubjectDao {
	public List<String> getSubjects();
	public List<String> getSubjectLevels(String subjectName);
}
