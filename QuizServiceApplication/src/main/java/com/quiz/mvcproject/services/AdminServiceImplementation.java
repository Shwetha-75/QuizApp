package com.quiz.mvcproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.mvcproject.entities.Admin;
import com.quiz.mvcproject.repositories.AdminRepository;

@Service
public class AdminServiceImplementation  implements AdminService
{
	@Autowired
	AdminRepository adminRepo;

	@Override
	public boolean validate(Admin admin) 
	{
		//first we area validating the admin email id
		if(adminRepo.findByEmail(admin.getEmail())==null)
		{
			return false;
		}
		else 
		{
			//checking password if and only if admin object exist
			//this is from database
			Admin adminresult=adminRepo.findByEmail(admin.getEmail());
			//                                   user entered password
			if(adminresult.getPassword().equals(admin.getPassword()))
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		
		
		
	}
	

}
