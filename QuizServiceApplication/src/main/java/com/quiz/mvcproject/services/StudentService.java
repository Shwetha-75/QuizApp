package com.quiz.mvcproject.services;

import com.quiz.mvcproject.entities.Student;

public interface StudentService 
{
	public String validateRegister(Student student);
	
	public String validateLogin(Student student);

	
	public Student getDetails(String email);

}
