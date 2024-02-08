package com.quiz.mvcproject.services;

import java.util.List;

import com.quiz.mvcproject.entities.Questionpython;


public interface PythonQuestionService 
{
public String addQuestions(Questionpython python);
	
	public String removeQuestion(int id);
	
	public String updateQuestion(Questionpython quiz);
	
	public List<Questionpython> fetchAll();

}
