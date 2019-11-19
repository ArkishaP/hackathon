package com.hackathon.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hackathon.model.Student;
import com.hackathon.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/studentReg", method=RequestMethod.GET)
	public ModelAndView getRegister(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("StudentRegistration");
		return mav;
	}
	
	
	@RequestMapping(value="/studentReg", method=RequestMethod.POST)
	public ModelAndView registerUser(HttpServletRequest request) throws ParseException{
		
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd"); 
		
		String studentid = request.getParameter("studentid");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Date dob=formatter.parse(request.getParameter("dob")); 
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String phoneno = request.getParameter("phoneno");
		
		
		Student student =new Student();
		student.setStudentId(studentid);
		student.setFirstName(first_name);
		student.setLastName(last_name);
		student.setGender(gender);
		student.setEmail(email);
		student.setPassword(password);
		student.setDob(dob);
		student.setCity(city);
		student.setState(state);
		student.setContactNumber(phoneno);;
		boolean flag=studentService.registerStudent(student);
		
		ModelAndView mav=new ModelAndView();
		if(flag)
			mav.setViewName("login");
			else
			
			mav.setViewName("StudentRegistration");
		return mav;
		

	}
	@RequestMapping(value = "/loginUser", method = RequestMethod.GET)
	public ModelAndView loginUserget() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("login");
		return mav;
	 }
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public ModelAndView loginUser(HttpServletRequest request) {
	    
		String studentid = request.getParameter("studentid");
		
		String password = request.getParameter("password");
		
		
		Student student =new Student();
		student.setStudentId(studentid);
		student.setPassword(password);
		
        boolean flag=studentService.loginStudent(student);
		
		ModelAndView mav=new ModelAndView();
		if(flag)
			mav.setViewName("dashboard");
			else
			
			mav.setViewName("login");
		return mav;
	  }


}
