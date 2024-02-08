package com.quiz.mvcproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.mvcproject.entities.Student;
import com.quiz.mvcproject.repositories.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService
{
	@Autowired
	StudentRepository studentRepo;

	
	//validating student registration process 
	//whether user as already registered or not
	
	//returns boolean value if student has not registered -->true or else false 
	@Override
	public String validateRegister(Student student) 
	{
		//getting the student object from db based on email
		if(studentRepo.findByEmail(student.getEmail())==null)
		{
			if(student.getConfirmpwd().equals(student.getPassword()))
			{
			
			//saving the object and returning true to indicate the student as successfully registered
			studentRepo.save(student);
			return "studentregistersuccesslogin";
			}
			else
			{
				//confirm and password are matching
				return "incorrectpwd";
			}
		}
		else
		{
			//if the student object already exist
			return "alreadyregister";
		}
		
	}
     
	
	
	//validating student login to check 
	//following cases
	//case 1: login in incorrect(invalid) password
	//case 2: login with email not yet registered
	@Override
	public String validateLogin(Student student) 
	{
		//first checking the email
		if(studentRepo.findByEmail(student.getEmail())!=null)
		{
			Student studResult=studentRepo.findByEmail(student.getEmail());
			//validating password
			if(student.getPassword().equals(studResult.getPassword()))
			{
				//case 1 if email and password both matches
				return "studenthome";
			}
			else
			{
				//case 1 if password does not matches
				return "studentfail";
			}
		}
		else
		{
			//case 2
			return "studentnotregister";
		}
		
	}
	
	

}
