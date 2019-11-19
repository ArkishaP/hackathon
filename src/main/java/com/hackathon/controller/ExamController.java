package com.hackathon.controller;

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
	
}
