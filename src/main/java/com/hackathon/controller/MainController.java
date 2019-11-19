package com.hackathon.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hackathon.model.Student;
import com.hackathon.service.StudentService;
import com.hackathon.service.SubjectService;

@Controller
public class MainController {
	@Autowired
	SubjectService subjectService;
	
	@RequestMapping(value="/newexam", method=RequestMethod.GET)
	public ModelAndView getSubjects(){
		ModelAndView mav = new ModelAndView("selectsubject");
		mav.addObject("subjects", subjectService.getSubjects());
		return mav;
	}
	
	@RequestMapping(value="/exam", method=RequestMethod.GET)
	public ModelAndView getSubject(HttpServletRequest request){
		String subjectId = request.getParameter("subject");
		ModelAndView mav = new ModelAndView("exampage");
		mav.addObject("subject",subjectId);
		return mav;
	}		
	
}
