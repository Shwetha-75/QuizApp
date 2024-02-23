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
	

	//returning the list of ids
	public List<Integer> getIdList() {

		return javRepo.findByIdsAll();
	}


	


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
	public String updateQuestion(Questionjava jav) 
	{
		Questionjava javObject=javRepo.findById(jav.getId());
		javObject.setQuestion(jav.getQuestion());
		javObject.setOption1(jav.getOption1());
		javObject.setOption2(jav.getOption2());
		javObject.setOption3(jav.getOption3());
		javObject.setOption4(jav.getOption4());
		javObject.setCorrectOption(jav.getCorrectOption());
		
		javRepo.save(javObject);
		return "updatedSuccessfully";
	}

	@Override
	public List<Questionjava> fetchAll() 
	{
		
		List<Questionjava> list=javRepo.findAll();
		System.out.println("Hello");
		return list;
	}
    
	@Override
	public Questionjava findByIdObject(int id) 
	{
		
		
		
		
		return javRepo.findById(id);
	}

}
