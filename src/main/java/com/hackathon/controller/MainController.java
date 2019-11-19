package com.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hackathon.service.SubjectService;

@Controller
public class MainController {
	@Autowired
	SubjectService subjectService;
	
	@RequestMapping(value="/selectexam")
	public ModelAndView getSubjects(){
		ModelAndView mav = new ModelAndView("startexam");
		mav.addObject("subjects", subjectService.getSubjects());
		return mav;
	}
}
