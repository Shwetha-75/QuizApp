package com.quiz.mvcproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.mvcproject.entities.Questionjava;
import com.quiz.mvcproject.repositories.JavaQuestionRepository;


@Service
public class JavaQuestionServiceImplementation implements JavaQuestionService
{
	@Autowired
	JavaQuestionRepository javRepo;

	@Override
	public String addQuestions(Questionjava jav) {
		javRepo.save(jav);
		return "questionCreated";
	}

	@Override
	public String removeQuestion(int id) {
		javRepo.deleteById(id);
		return "deletedSuccessfully";
	}

	@Override
	public String updateQuestion(Questionjava jav) {
		javRepo.save(jav);
		return "updatedSuccessfully";
	}

	@Override
	public List<Questionjava> fetchAll() 
	{
		List<Questionjava> list=javRepo.findAll();
		System.out.println("Hello");
		return list;
	}

}
