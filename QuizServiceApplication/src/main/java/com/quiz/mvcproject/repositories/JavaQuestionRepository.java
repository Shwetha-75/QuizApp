package com.quiz.mvcproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.mvcproject.entities.Questionjava;

public interface JavaQuestionRepository extends JpaRepository<Questionjava, Integer> 
{
  public Questionjava findById(int id);

}
