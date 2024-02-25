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
		//for updation 
		//step 1--> get the previous data
		//step 2-->set the data
		//update it or save 
        
		Questionpython quespyt=pytRepo.findById(pyt.getId());
		quespyt.setQuestion(pyt.getQuestion());
		quespyt.setOption1(pyt.getOption1());
		quespyt.setOption2(pyt.getOption2());
                quespyt.setOption3(pyt.getOption3());
                quespyt.setOption4(pyt.getOption4());
                quespyt.setCorrectOption(pyt.getCorrectOption());
		pytRepo.save(quespyt);
		pytRepo.save(pyt);
		return "updatedSuccessfully";
	}

	@Override
	public List<Questionpython> fetchAll() {
		List<Questionpython> list=pytRepo.findAll();
		return list;
	}

}
