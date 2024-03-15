package com.quiz.mvcproject.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.quiz.mvcproject.entities.Questionpython;
import com.quiz.mvcproject.services.PythonQuestionService;

@Controller
public class PythonController 
{
	@Autowired
	PythonQuestionService pytService;
	
	
	@GetMapping("/pyt-map")
	public List<Questionpython> fetchAll()
	{
		
//		System.out.println(pytService.fetchAll());
	
		return pytService.fetchAll();
	}
}
