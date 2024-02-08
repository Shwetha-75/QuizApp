package com.quiz.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.quiz.mvcproject.entities.Questionjava;
import com.quiz.mvcproject.services.JavaQuestionService;


@Controller
public class QuestionJavaController 
{
	@Autowired
	JavaQuestionService javService;
	
	@PostMapping("/javcreateQuestion")
	public String addQuestions(@ModelAttribute Questionjava jav) 
	{
		
		String msg=javService.addQuestions(jav);
		return msg;
	}

	@PostMapping("/javremoveQuestion")
	public String removeQuestion(@RequestParam int id) 
	{
		String msg=javService.removeQuestion(id);
		return msg;
	}

	@PostMapping("/javupdateQuestion")
	public String updateQuestion(@ModelAttribute Questionjava jav) 
	{	
		String msg=javService.updateQuestion(jav);
		return msg;
	}

	@GetMapping("/javfetchAll")
	public String fetchAll(Model model) 
	{
		List<Questionjava> list=javService.fetchAll();
		System.out.println("Hello");
		model.addAttribute("quizQuestions",list);
		return "viewAll";
	}
	


}
