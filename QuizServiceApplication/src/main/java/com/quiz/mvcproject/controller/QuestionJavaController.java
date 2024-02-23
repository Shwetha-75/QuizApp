package com.quiz.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.quiz.mvcproject.entities.Questionjava;
import com.quiz.mvcproject.services.JavaQuestionService;
import com.quiz.mvcproject.services.JavaQuestionServiceImplementation;


@Controller
public class QuestionJavaController 
{
	@Autowired
	JavaQuestionService javService;
	
	Questionjava javQuestion;
	
	
     
	//we cannot have the List<Integer> listid=javService.getIdList as instance variable
	//since this is specific to QuestionJavaController class we are instanciating the class 
	//any where and also i cannot have it as ststaic variable since javService reference
	//memory will be allocated at the run time
	
	
	@PostMapping("/javcreateQuestion")
	public String addQuestions(@ModelAttribute Questionjava jav) 
	{
		
		String msg=javService.addQuestions(jav);
		return msg;
	}

	@PostMapping("/javremoveQuestion")
	public String removeQuestion(@RequestParam int id) 
	{
		//getIdList lists the id;s avaliable in table and 
		//returns all ths ids 
		//we have to check for if the id exists in the list or not
		if(javService.getIdList().contains(id))
		{
			String msg=javService.removeQuestion(id);
			return msg;
		}
		else
		{
			return "iddoesnotexists";
		}
		
	}

	@PostMapping("/javupdateQuestion")
	public String updateQuestion(@ModelAttribute Questionjava jav) 
	{	
		
		String msg=javService.updateQuestion(jav);
		return msg;
	}

	@GetMapping("/javfetchAll")
	public String fetchAll(Model model) 
	{
		List<Questionjava> list=javService.fetchAll();
		System.out.println("Hello");
		model.addAttribute("quizQuestions",list);
		return "viewAll";
	}
	
	@GetMapping("/map-javpaper")
	public String javPaper(Model model)
	{
		List<Questionjava> list=javService.fetchAll();
		model.addAttribute("list", list);
		
		return "javquestionpaper";
		
	}
	
	
	//receive a request parameter as id 
	//using this id we will create a model 
	//ans display that to the update form
	@PostMapping("/map-updatejavaid")
	public String updateQuestionDisplayModel(@RequestParam int id, Model model)
	{
		//getIdList lists the id;s avaliable in table and 
				//returns all ths ids 
				//we have to check for if the id exists in the list or not
		if(javService.getIdList().contains(id))
		{
		    Questionjava javObject=javService.findByIdObject(id);
		    model.addAttribute("javObject", javObject);
		
		    return "javupdateQuestion";
		}
		else
		{
			return "iddoesnotexists";
		}
	}
	


}
