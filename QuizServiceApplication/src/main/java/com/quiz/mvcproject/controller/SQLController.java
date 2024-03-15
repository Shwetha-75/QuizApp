package com.quiz.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.quiz.mvcproject.entities.Questionsql;
import com.quiz.mvcproject.services.SQLQuestionService;

@Controller
public class SQLController 
{
	@Autowired
	SQLQuestionService sqlService;
	
	
	@GetMapping("/sql-map")
	public List<Questionsql> fetchAll()
	{
		return sqlService.fetchAll();
	}
}
