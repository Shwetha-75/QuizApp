package com.quiz.mvcproject.controller;
import com.quiz.mvcproject.entities.Student;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.mvcproject.entities.Questionpython;
import com.quiz.mvcproject.entities.Student;
import com.quiz.mvcproject.services.PythonQuestionService;

@RestController
public class PythonController 
{
	@Autowired
	PythonQuestionService pytService;
	Student student;
	
	public PythonController(Student student)
	{
		this.student=student;
		
	}
	
	@GetMapping("/pyt-map")
	public List<Questionpython> pytpaper(Model model)
	{
		
		
		model.addAttribute("student",student);
		
		return pytService.fetchAll();
	}
	

}
