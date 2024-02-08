package com.quiz.mvcproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.quiz.mvcproject.entities.Questionsql;
import com.quiz.mvcproject.repositories.SQLQuestionRepository;



@Service
public class SQLQuestionServiceImplementation implements SQLQuestionService
{
	@Autowired
	SQLQuestionRepository sqlRepo;

	@Override
	public String addQuestions(Questionsql sq) {
		sqlRepo.save(sq);
		return "questionCreated";
	}

	@Override
	public String removeQuestion(int id) {
		sqlRepo.deleteById(id);
		return "deletedSuccessfully";
	}

	@Override
	public String updateQuestion(Questionsql sq) {
		sqlRepo.save(sq);
		return "updatedSuccessfully";
	}

	@Override
	public List<Questionsql> fetchAll() {
		List<Questionsql> list=sqlRepo.findAll();
		return list;
	}

	
}
