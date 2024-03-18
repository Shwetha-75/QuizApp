package com.quiz.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.mvcproject.entities.Questionjava;
import com.quiz.mvcproject.services.JavaQuestionService;


/*Make sure that it has to be rest controller */
@RestController
public class JavController 
{
	@Autowired
	JavaQuestionService javService;

	
	
	@GetMapping("/jav-map")
	public List<Questionjava> javPaper()
	{
		return javService.fetchAll();
	}
}
