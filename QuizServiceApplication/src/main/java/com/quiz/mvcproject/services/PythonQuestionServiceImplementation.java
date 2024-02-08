package com.quiz.mvcproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.mvcproject.entities.Questionpython;
import com.quiz.mvcproject.repositories.PythonQuestionRepository;

@Service
public class PythonQuestionServiceImplementation implements PythonQuestionService{

	@Autowired
	PythonQuestionRepository pytRepo;
	
	@Override
	public String addQuestions(Questionpython pyt) {
		pytRepo.save(pyt);
		return "questionCreated";
	}

	@Override
	public String removeQuestion(int id) {
		pytRepo.deleteById(id);
		return "deletedSuccessfully";
	}

	@Override
	public String updateQuestion(Questionpython pyt) {
		pytRepo.save(pyt);
		return "updatedSuccessfully";
	}

	@Override
	public List<Questionpython> fetchAll() {
		List<Questionpython> list=pytRepo.findAll();
		return list;
	}

}
