package com.quiz.mvcproject.services;

import java.util.List;

import com.quiz.mvcproject.entities.Questionjava;


public interface JavaQuestionService 
{
public String addQuestions(Questionjava jav);
	
	public String removeQuestion(int id);
	
	public String updateQuestion(Questionjava jav);
	
	public List<Questionjava> fetchAll();
    
	public Questionjava findByIdObject(int id);
	
	
	public List<Integer> getIdList();
	
}
