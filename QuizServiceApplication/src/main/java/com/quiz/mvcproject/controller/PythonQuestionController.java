package com.quiz.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.mvcproject.entities.Questionpython;
//import com.quiz.mvcproject.entities.Quiz;
import com.quiz.mvcproject.services.PythonQuestionService;

@Controller
public class PythonQuestionController 
{
	@Autowired
	PythonQuestionService pythonService;
	
	@PostMapping("/pytcreateQuestion")
	public String addQuestions(@ModelAttribute Questionpython pyt) 
	{
		//creating object and saving the bean
		String msg=pythonService.addQuestions(pyt);
		return msg;
	}

	@PostMapping("/pytremoveQuestion")
	public String removeQuestion(@RequestParam int id) 
	{
		if(pythonService.getIdAll().contains(id))
		{
			String msg=pythonService.removeQuestion(id);
			return msg;
		}
		else
		{
			return "iddoesnotexists";
		}
		
	}
	//changes applied in uodate 
	//it should display the data before updation 
	//admin can make tha vhanges easily
	@PostMapping("/map-pytupdatelist")
	public String updateQuestionDisplayModel(@RequestParam int id,Model model)
	{
		//findby id method will returns the object 
		//by id 
		//System.out.println(id);
		
		//we have to check whether id exists or not 
		if(pythonService.getIdAll().contains(id))
		{
			Questionpython pyt=pythonService.findByIdObject((id));
			model.addAttribute("pyt", pyt);//creating model 
			return "pytupdateQuestion";
		}
		else
		{
			return "iddoesnotexists";
		}
		
	}

	@PostMapping("/pytupdateQuestion")
	public String updateQuestion(@ModelAttribute Questionpython pyt) 
	{	
		String msg=pythonService.updateQuestion(pyt);
		return msg;
	}

	@GetMapping("/pytfetchAll")
	public String fetchAll(Model model) 
	{
		List<Questionpython> list=pythonService.fetchAll();//fecting all the objects 
		model.addAttribute("quizQuestions",list);//creating the model
		return "viewAll";
	}
	

}
