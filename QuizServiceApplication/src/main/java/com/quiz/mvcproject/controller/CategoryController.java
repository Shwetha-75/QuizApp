package com.quiz.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.mvcproject.entities.Questionjava;
import com.quiz.mvcproject.entities.Questionpython;
import com.quiz.mvcproject.entities.Questionsql;
import com.quiz.mvcproject.services.JavaQuestionService;
import com.quiz.mvcproject.services.PythonQuestionService;
import com.quiz.mvcproject.services.SQLQuestionService;

@Controller
public class CategoryController 
{
	@Autowired
	JavaQuestionService javService;
	@Autowired
	PythonQuestionService pytService;
	@Autowired
	SQLQuestionService sqlService;
	
	
	
	@PostMapping("/createcategory")
	public String create(@RequestParam String sub, Model model)
	{
		
		if(sub.equals("jav"))
		{
			return "javcreateQuestion";
		}
		else if(sub.equals("pyt"))
		{
			return "pytcreateQuestion";
		}
		else
		{
			return "sqcreateQuestion";
		}
	}
	@PostMapping("/updatecategory")
	public String update(@RequestParam String sub, Model model)
	{
		//updated since during updation admin as to remember all the question and option
		//making it simple to use 
		//if admin selects id means it has to display the object and deatils in form
		
		if(sub.equals("jav"))
		{
			String data="JAVA";
			//returns the list of all th objects
			List<Questionjava> list=javService.fetchAll();
			//creating the model to display the data 
			//data is to ensure which technology they are using
			model.addAttribute("data", data);
			//creating model which will have the list of objects
			////listing all the objects
			model.addAttribute("list", list);
			//return the template
			return "listquestionjavid";
		}
		 else if(sub.equals("pyt"))
		{
            String data="PYTHON";
          //returns the list of all th objects
			List<Questionpython> list=pytService.fetchAll();
			//creating the model to display the data 
			//data is to ensure which technology they are using
			model.addAttribute("data", data);
			//creating model which will have the list of objects
			////listing all the objects
			model.addAttribute("list", list);
			//return the template
			return "listquestionpytid";
		}
		else
		{
            String data="SQL";
            //returns the list of all th objects
			
			List<Questionsql> list=sqlService.fetchAll();
			//creating the model to display the data 
			//data is to ensure which technology they are using
			model.addAttribute("data", data);
			//creating model which will have the list of objects
			////listing all the objects
			model.addAttribute("list", list);
			//return the template
			return "listquestionsqlid";
		}
	}
	@PostMapping("/removecategory")
	public String remove(@RequestParam String sub, Model model)
	{
		if(sub.equals("jav"))
		{
			return "javremoveQuestion";
		}
		else if(sub.equals("pyt"))
		{
			return "pytremoveQuestion";
		}
		else
		{
			return "sqremoveQuestion";
		}
	}
	@PostMapping("/fetchAll")
	public String view(@RequestParam String sub, Model model)
	{
		if(sub.equals("jav"))
		{
			return "javfetchAll";
		}
		else if(sub.equals("pyt"))
		{
			return "pytfetchAll";
		}
		else
		{
			return "sqfetchAll";
		}
	}
}
