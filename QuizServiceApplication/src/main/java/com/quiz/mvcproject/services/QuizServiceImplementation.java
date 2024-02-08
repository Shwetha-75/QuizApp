package com.quiz.mvcproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.mvcproject.entities.Quiz;
import com.quiz.mvcproject.repositories.QuizQuestionRepository;

@Service
public class QuizServiceImplementation implements QuizServices
{
	@Autowired
	QuizQuestionRepository repo;
	@Override
	public String addQuestions(Quiz quiz) {
		repo.save(quiz);
		return "questionCreated";
	}

	@Override
	public String removeQuestion(int id) {
		repo.deleteById(id);
		return "deletedSuccessfully";
	}

	@Override
	public String updateQuestion(Quiz quiz) {
		repo.save(quiz);
		return "updatedSuccessfully";
	}

	@Override
	public List<Quiz> fetchAll() {
		List<Quiz> list=repo.findAll();
		return list;
	}
	

}
