package com.quiz.mvcproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.mvcproject.entities.Questionsql;

public interface SQLQuestionRepository extends JpaRepository<Questionsql, Integer>{

}
