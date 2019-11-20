package com.hackathon.service;

import java.util.List;

import com.hackathon.model.Subject;

public interface SubjectService {
	public List<String> getSubjects();
	public List<String> getSubjectLevels(String subjectName);
}
