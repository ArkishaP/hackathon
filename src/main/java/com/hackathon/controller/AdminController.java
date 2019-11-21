package com.hackathon.controller;

import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hackathon.dao.AdminDaoIntf;
import com.hackathon.model.Admin;
import com.hackathon.model.Subject;
import com.hackathon.service.AdminServiceIntf;
@Controller
public class AdminController {
	@Autowired
	AdminDaoIntf admindao;
	@Autowired
	AdminServiceIntf adminservice;
	
	@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	public ModelAndView loginAdmin() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("Adminlogin");
		return mav;
	 }
	
	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	public ModelAndView loginAdmin(HttpServletRequest request) {
	    
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		Admin admin = new Admin(); 
		admin.setUsername(username);
		admin.setPassword(password);
		
        boolean flag=adminservice.loginAdmin(admin);
		
		ModelAndView mav=new ModelAndView();
		if(flag)
			mav.setViewName("AdminDashboard");
			else
			
			mav.setViewName("Adminlogin");
		  
		return mav;
	  }

	
	@RequestMapping(value="/addsubject", method=RequestMethod.GET)
	public ModelAndView addSubject(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("upload");
		return mav;
	}
	
	
	@RequestMapping(value="/addsubject", method=RequestMethod.POST)
	public ModelAndView addSubject(HttpServletRequest request) throws ParseException{
		
		
		String subid = request.getParameter("subid");
		String subname = request.getParameter("subname");
		String level = request.getParameter("level");
		Integer duration = Integer.parseInt(request.getParameter("time"));
		String file = request.getParameter("file");
		
		Subject sub = new Subject(); 
		sub.setSubjectId(subid);
		sub.setSubjectName(subname);
		sub.setDifficulty(level);
		sub.setDuration(duration);
		sub.setQuestionFile(file);
		
		boolean flag=adminservice.addSubject(sub);
		
		ModelAndView mav=new ModelAndView();
		if(flag){
			mav.setViewName("upload");
			mav.addObject("boom","Updated details Successfully");}
			else
				{mav.setViewName("upload");
				mav.addObject("boom","Failed");}
		return mav;
		

	}
}
