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
		return msg;
	}
}
