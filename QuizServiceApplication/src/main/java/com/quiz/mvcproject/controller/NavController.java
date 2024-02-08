package com.quiz.mvcproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController 
{
	@GetMapping("/map-studentlogin")
	public String studentLogin()
	{
		return "studentlogin";
	}
	@GetMapping("/map-studentregister")
	public String studentRegister()
	{
		return "studentregister";
	}
	@GetMapping("/map-studentpage")
	public String studentPage()
	{
		return "studentpage";
	}
	@GetMapping("/map-adminhome")
	public String adminHome()
	{
		return "adminhome";
	}
	@GetMapping("/map-adminlogin")
	public String adminLogin()
	{
		return "adminlogin";
	}
	@GetMapping("/map-add")
	public String addQuestion()
	{
		return "createcategory";
	}
	@GetMapping("/map-remove")
	public String removeQuestions()
	{
		return "removecategory";
	}
	
	@GetMapping("/map-update")
	public String updateQuestions()
	{
		return "updatecategory";
	}
	@GetMapping("/map-view")
	public String viewQuestion()
	{
		return "viewcategory";
	}
}
