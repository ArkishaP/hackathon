package com.hackathon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hackathon.service.ExamService;

@Controller
public class ExamController {
	@Autowired
	ExamService examService;
	
	@RequestMapping(value="/dashboard", method = RequestMethod.GET)
	public ModelAndView selectSubject() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("subjects",examService.getSubjectNames());
		mav.setViewName("dashboard");
		return mav;
	}
	
	@RequestMapping(value="/exam")
	public ModelAndView redirectToInstructions(HttpServletRequest request, HttpSession session){
		ModelAndView mav = new ModelAndView();
		String subjectName = request.getParameter("subject");
		String studentId = (String)session.getAttribute("studentId");
		String exam = examService.selectExam(studentId, subjectName);
		mav.addObject("subject", subjectName);
		mav.addObject("exam",exam);
		mav.setViewName("instructions");
		return mav;
	}
	
	@RequestMapping(value="/startexam", method=RequestMethod.GET)
	public ModelAndView redirectToExamPage(HttpServletRequest request, HttpSession session){
		ModelAndView mav = new ModelAndView("exampage");
		String subjectName = request.getParameter("subject");
		String studentId = (String)session.getAttribute("studentId");
		mav.addObject("subject", subjectName);
		mav.addObject("student",studentId);
		String exam = examService.selectExam(studentId, subjectName);
		mav.addObject("exam", exam);
		mav.addObject("questions", examService.getQuestions(exam));
		System.out.println(exam);
		
		return mav;
	}
	
}
