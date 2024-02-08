package com.quiz.mvcproject.services;

import java.util.List;

import com.quiz.mvcproject.entities.Quiz;

public interface QuizServices 
{

	public String addQuestions(Quiz quiz);
	
	public String removeQuestion(int id);
	
	public String updateQuestion(Quiz quiz);
	
	public List<Quiz> fetchAll();
	
	
}
