package com.quiz.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.mvcproject.entities.Quiz;
import com.quiz.mvcproject.services.QuizServices;

@Controller
public class QuizController 
{
	@Autowired
	QuizServices quizService;
	
	@PostMapping("/createQuestion")
	public String addQuestions(@ModelAttribute Quiz quiz) 
	{
		String msg=quizService.addQuestions(quiz);
		return msg;
	}

	@PostMapping("/removeQuestion")
	public String removeQuestion(@RequestParam int id) 
	{
		String msg=quizService.removeQuestion(id);
		return msg;
	}

	@PostMapping("/updateQuestion")
	public String updateQuestion(@ModelAttribute Quiz quiz) 
	{	
		String msg=quizService.updateQuestion(quiz);
		return msg;
	}

	@GetMapping("/fetchAll")
	public String fetchAll(Model model) 
	{
		List<Quiz> list=quizService.fetchAll();
		model.addAttribute("quizQuestions",list);
		return "viewAll";
	}
	

}
