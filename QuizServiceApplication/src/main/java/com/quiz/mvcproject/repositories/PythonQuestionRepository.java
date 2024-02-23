package com.quiz.mvcproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quiz.mvcproject.entities.Questionpython;

public interface PythonQuestionRepository extends JpaRepository<Questionpython,Integer> 
{
	
	public Questionpython findById(int id);
	
	
	
	@Query(value="select id from questionpython", nativeQuery=true)
	public List<Integer> findByIdsAll();

}
