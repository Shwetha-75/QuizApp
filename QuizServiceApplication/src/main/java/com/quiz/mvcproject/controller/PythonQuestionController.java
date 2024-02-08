package com.quiz.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.mvcproject.entities.Questionpython;
//import com.quiz.mvcproject.entities.Quiz;
import com.quiz.mvcproject.services.PythonQuestionService;

@Controller
public class PythonQuestionController 
{
	@Autowired
	PythonQuestionService pythonService;
	
	@PostMapping("/pytcreateQuestion")
	public String addQuestions(@ModelAttribute Questionpython pyt) 
	{
		String msg=pythonService.addQuestions(pyt);
		return msg;
	}

	@PostMapping("/pytremoveQuestion")
	public String removeQuestion(@RequestParam int id) 
	{
		String msg=pythonService.removeQuestion(id);
		return msg;
	}

	@PostMapping("/pytupdateQuestion")
	public String updateQuestion(@ModelAttribute Questionpython pyt) 
	{	
		String msg=pythonService.updateQuestion(pyt);
		return msg;
	}

	@GetMapping("/pytfetchAll")
	public String fetchAll(Model model) 
	{
		List<Questionpython> list=pythonService.fetchAll();
		model.addAttribute("quizQuestions",list);
		return "viewAll";
	}
	

}
