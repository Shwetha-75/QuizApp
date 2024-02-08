package com.quiz.mvcproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.mvcproject.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>
{
	public Admin findByEmail(String email);

}
