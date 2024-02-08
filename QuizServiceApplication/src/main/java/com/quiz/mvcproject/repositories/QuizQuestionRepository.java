package com.quiz.mvcproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.mvcproject.entities.Quiz;

public interface QuizQuestionRepository extends JpaRepository<Quiz, Integer>
{
	

}
