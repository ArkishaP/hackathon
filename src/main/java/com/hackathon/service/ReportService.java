package com.hackathon.service;

import java.util.List;

import com.hackathon.model.Report;

public interface ReportService {
	public List<Object[]> getReport(String studentId);
	public List<Object[]> searchStudent(String subjectName,String difficulty,int score);


}
