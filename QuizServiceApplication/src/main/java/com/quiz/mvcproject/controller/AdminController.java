package com.quiz.mvcproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.quiz.mvcproject.entities.Admin;
import com.quiz.mvcproject.services.AdminService;

@Controller
public class AdminController 
{
	@Autowired
	AdminService adminService;
	
	
	@PostMapping("/adminlogin")
	public String validate(@ModelAttribute Admin admin)
	{
		if(adminService.validate(admin))
		{
			return "adminhome";
		}
		else
		{
			return "adminfail";
			
		}
		
	}
	

}
