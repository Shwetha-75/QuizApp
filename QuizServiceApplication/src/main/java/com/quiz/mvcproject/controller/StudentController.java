package com.quiz.mvcproject.controller;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.quiz.mvcproject.entities.Student;

import com.quiz.mvcproject.services.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	Student detail;
	

	// creating student home page there was a probelm in display the student fname
	// in home page
	// so creating the student home method ater it parse the fnam e
	// form the created model
	@GetMapping("/studenthome")
	public String studentHome(Model model)
	{
		model.addAttribute("detail", detail);
		return "studenthome";
	}

	@PostMapping("/studentregister")
	public String validateRegister(@ModelAttribute Student student) {
		String msg = studentService.validateRegister(student);
		return msg;
	}

	@PostMapping("/studentlogin")
	public String validateLogin(Student student, Model model) {
		String msg = studentService.validateLogin(student);
		if (msg.equals("studenthome")) {
			// Previous approach
			// detail=student;---> this student object contains only email and password
			// value for only to those attributes
			// so creating the another method to work the functionality to get only
			// obj of student object matching with email

			detail = studentService.getDetails(student.getEmail());
			model.addAttribute("detail", detail);
			return msg;
		}
		return msg;
	}
	
	

	@GetMapping("/profile")
	public String profile(Model model) {
		// System.out.println(detail);
		// creating the model

		model.addAttribute("detail", detail);

		// System.out.println(detail);
		return "studentprofile";
	}

	// There was a problem while trouble shooting
	// Resolved
	// Mistake was proper mapping was not there from view to controller class
	// the mistake is in navcontroller when it was returning the template
	// in edit student profile it was parsing for the object the object was not yet
	// createed
	// so changed mapping from NavControoler to Student Controller

	// for mapping for edit student profile
	@PostMapping("/editstudentprofile")
	public String displaymodelforupdate(Model model) {
		// System.out.println(detail); //testing

		model.addAttribute("detail", detail);
		return "editstudentprofile";
	}

	// for saving the updated bean
	// isssuse raised ---> Content-Type not supported
	// mistake was Annotation it should be of ModelAttribute
	// but i have used befpre Request body
	@PostMapping("/editprofile")
	public String updatestudent(@ModelAttribute Student student) {
		//System.out.println(student);
		detail=studentService.updateStudent(student);
		return "updatestudentsuccess";
	}
	
	PythonController pytCtrl=new PythonController(detail);
	
	
	
}
