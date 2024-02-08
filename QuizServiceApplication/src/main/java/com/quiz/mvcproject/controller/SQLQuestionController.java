package com.quiz.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.quiz.mvcproject.entities.Questionsql;

import com.quiz.mvcproject.services.SQLQuestionService;

@Controller
public class SQLQuestionController 
{
	@Autowired
	SQLQuestionService sqlService;
	
	@PostMapping("/sqcreateQuestion")
	public String addQuestions(@ModelAttribute Questionsql sq) 
	{
		String msg=sqlService.addQuestions(sq);
		return msg;
	}

	@PostMapping("/sqremoveQuestion")
	public String removeQuestion(@RequestParam int id) 
	{
		String msg=sqlService.removeQuestion(id);
		return msg;
	}

	@PostMapping("/squpdateQuestion")
	public String updateQuestion(@ModelAttribute Questionsql sq) 
	{	
		String msg=sqlService.updateQuestion(sq);
		return msg;
	}

	@GetMapping("/sqfetchAll")
	public String fetchAll(Model model) 
	{
		List<Questionsql> list=sqlService.fetchAll();
		model.addAttribute("quizQuestions",list);
		return "viewAll";
	}
	

}
