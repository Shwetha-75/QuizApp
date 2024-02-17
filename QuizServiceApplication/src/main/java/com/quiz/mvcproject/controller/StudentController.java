package com.quiz.mvcproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.quiz.mvcproject.entities.Student;
import com.quiz.mvcproject.services.StudentService;

@Controller
public class StudentController 
{
	@Autowired
	StudentService studentService;
	Student detail;
	
	@GetMapping("/studenthome")
	public String studentHome(Model model)
	{
		model.addAttribute("detail", detail);
		return "studenthome";
	}
	@PostMapping("/studentregister")
	public String validateRegister(@ModelAttribute Student student)
	{
		String msg=studentService.validateRegister(student);
		return msg;
	}
	
	@PostMapping("/studentlogin")
	public String validateLogin(Student student)
	{
		String msg=studentService.validateLogin(student);
		if(msg.equals("studenthome"))
		{
			detail=studentService.getDetails(student.getEmai());
		}
		return msg;
	}
	@GetMapping("/profile")
	public String profile(Model model)
	{
		model.addAttribute("detail",detail);
		return "studentprofile";
	}
	@PostMapping("/editstudentprofile")
	public String displaymodelforupdate(Model model)
	{
		//System.out.println(detail);  //testing
		
		model.addAttribute("detail",detail);
		return "editstudentprofile";
	}
	
}
