package com.quiz.mvcproject.services;

import java.util.List;


import com.quiz.mvcproject.entities.Questionsql;

public interface SQLQuestionService 
{
public String addQuestions(Questionsql sql);
	
	public String removeQuestion(int id);
	
	public String updateQuestion(Questionsql quiz);
	
	public List<Questionsql> fetchAll();

}
