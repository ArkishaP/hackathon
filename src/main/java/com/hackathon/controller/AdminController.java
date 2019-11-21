package com.hackathon.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hackathon.dao.AdminDaoIntf;
import com.hackathon.model.Admin;
import com.hackathon.model.Student;
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

}
