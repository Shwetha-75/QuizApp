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
		Questionsql sqlObject=sqlRepo.findById(sq.getId());
		sqlObject.setId(sq.getId());
		sqlObject.setQuestion(sq.getQuestion());
		sqlObject.setOption1(sq.getOption1());
		sqlObject.setOption2(sq.getOption2());
		sqlObject.setOption3(sq.getOption3());
		sqlObject.setOption4(sq.getOption4());
		sqlObject.setCorrectOption(sq.getCorrectOption());
		
		sqlRepo.save(sq);
		return "updatedSuccessfully";
	}

	@Override
	public List<Questionsql> fetchAll() {
		List<Questionsql> list=sqlRepo.findAll();
		return list;
	}

	
}
