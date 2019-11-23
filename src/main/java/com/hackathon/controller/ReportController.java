package com.hackathon.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hackathon.model.Report;
import com.hackathon.service.ReportService;

@Controller
public class ReportController {
	@Autowired
	ReportService reportservice;
	
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public ModelAndView viewReport(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
//		String studentId=(String) session.getAttribute("studentId");
		String studentId="S0001";
		List<Object[]>  replist = reportservice.getReport(studentId);
		
		 ModelAndView mav = new ModelAndView("report");
		 mav.addObject("replist", replist);
		 return mav;
	 }
	
	@RequestMapping(value="/adminSearch" , method=RequestMethod.GET)	
	public String redirectSearchStudent(){
		return "AdminSearch";
	}
	
	@RequestMapping(value="/adminSearch" , method=RequestMethod.POST)
	public ModelAndView searchStudent(HttpServletRequest request, HttpServletResponse response) {
		String subjectName=(String) request.getAttribute("subjectName");
		String difficulty=(String) request.getAttribute("difficulty");
		System.out.println("here");
		int score = Integer.parseInt((String)request.getAttribute("score"));
//		int score= (Integer) request.getAttribute("score");
		
		List<Object[]>  stlist = reportservice.searchStudent(subjectName, difficulty, score);
		System.out.println("idhar");
		 ModelAndView mavv = new ModelAndView();
		 mavv.setViewName("SearchedResult");
		 mavv.addObject("stlist", stlist);
		 return mavv;
	 }
}
