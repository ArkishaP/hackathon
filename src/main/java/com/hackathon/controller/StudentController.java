package com.hackathon.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView getRegister(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("StudentRegistration");
		return mav;
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
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
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginUserget() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("login");
		return mav;
	 }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginUser(HttpServletRequest request) {
	    
		String studentId = request.getParameter("studentid");
		
		String password = request.getParameter("password");
		
		
		Student student =new Student();
		student.setStudentId(studentId);
		student.setPassword(password);
		
        boolean flag=studentService.loginStudent(student);
		
		ModelAndView mav=new ModelAndView();
		if(flag){
			mav.setViewName("redirect:/dashboard.do");
			HttpSession session = request.getSession();
			session.setAttribute("studentId", studentId);
		}
			else
			
			mav.setViewName("login");
		return mav;
	  }
	@RequestMapping(value = "/changepwd", method = RequestMethod.GET)
	  public ModelAndView changepwd1(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("changepwd");
	    return mav;
	  }
	
	
	/*@RequestMapping(value = "/changepwd", method = RequestMethod.POST)
	  public ModelAndView changepwd2(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
    String username=(String)session.getAttribute("studentid");
    String opwd= request.getParameter("opassword");
    String npwd= request.getParameter("npassword");
    System.out.println(username+"  "+opwd+"  "+npwd);
	boolean flag = studentService.changepwd(studentid,opwd,npwd);
    if(flag) {
	       ModelAndView mav = new ModelAndView("changepwd");
	       mav.addObject("message", "Password is successfully updated");
	       return mav;
	  }
    else {
    	ModelAndView mav = new ModelAndView("changepwd");
	       mav.addObject("message", "Password is not updated");
	       return mav;
    }
	}*/


}
