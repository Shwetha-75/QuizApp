package com.quiz.mvcproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CategoryController 
{
	@Autowired
	JavaQuestionService javService;
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
		if(sub.equals("jav"))
		{
			List<Questionjava> list=javService.fetchAll();
			model.addAttribute("data",data);
			model.addAttribute("list",list);
			return "listjavaid";
		}
		else if(sub.equals("pyt"))
		{
			return "pytupdateQuestion";
		}
		else
		{
			return "squpdateQuestion";
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
