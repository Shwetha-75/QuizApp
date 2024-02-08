package com.quiz.mvcproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.mvcproject.entities.Questionpython;

public interface PythonQuestionRepository extends JpaRepository<Questionpython,Integer> {

}
