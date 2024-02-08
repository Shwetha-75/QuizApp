package com.quiz.mvcproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.mvcproject.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>
{
	public Student findByEmail(String email);

}
