package com.quiz.mvcproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quiz.mvcproject.entities.Questionsql;

public interface SQLQuestionRepository extends JpaRepository<Questionsql, Integer>
{
	public Questionsql findById(int id);
	
	
	//refer javaquestionrepository
	
	@Query(value="select id from questionsql",nativeQuery=true)
	public List<Integer> findByIdsAll();
	

}
