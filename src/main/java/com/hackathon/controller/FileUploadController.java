package com.hackathon.controller;

	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.multipart.MultipartFile;
	import org.springframework.web.servlet.ModelAndView;
	import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hackathon.model.Subject;
import com.hackathon.service.AdminServiceIntf;
import com.hackathon.service.FileUploadService;


	@Controller
	public class FileUploadController {
		
		@Autowired
		FileUploadService fileUploadService;
		@Autowired
		AdminServiceIntf adminservice;
		
		@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	    public ModelAndView index1() {
	        return new ModelAndView("upload");
	    }

		@RequestMapping(value = "/AdminLogin", method = RequestMethod.GET)
	    public ModelAndView index2() {
	        return new ModelAndView("AdminLogin");
	    }
	    
		@RequestMapping(value = "/upload", method = RequestMethod.POST)
	    public ModelAndView singleFileUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file,
	                                   RedirectAttributes redirectAttributes) {
			
			String subid = request.getParameter("subid");
			String subname = request.getParameter("subname");
			String level = request.getParameter("level");
			Integer duration = Integer.parseInt(request.getParameter("time"));
			String filename = subid+".xlsx";
			
			Subject sub = new Subject(); 
			sub.setSubjectId(subid);
			sub.setSubjectName(subname);
			sub.setDifficulty(level);
			sub.setDuration(duration);
			sub.setQuestionFile(filename);
			
			boolean flag=adminservice.addSubject(sub);

			if (file.isEmpty()) {
	            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	            return new ModelAndView("upload","message", "Please select a file to upload");
	        }

	        try {
	        	
	            // Get the file and save it somewhere
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get("C://temp//" + filename);
	            Files.write(path, bytes);
	            
	            fileUploadService.uploadFileData("C://temp//"+path.getFileName(),subid);

	            redirectAttributes.addFlashAttribute("message", 
	                        "You successfully uploaded '" + file.getOriginalFilename() + "'");

	        } catch (IOException e) {
	        	redirectAttributes.addFlashAttribute("message", 
	                    "Failure occured during upload '" + file.getOriginalFilename() + "'");
	            e.printStackTrace();
	        }

			
	        return new ModelAndView("upload","message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
	    }
		
		@RequestMapping(value="/test", method=RequestMethod.POST)
		public void test(HttpServletRequest request){
			System.out.println("Here");
		}
	}


