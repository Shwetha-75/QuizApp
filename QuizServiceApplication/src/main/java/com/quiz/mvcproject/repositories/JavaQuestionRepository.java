package com.quiz.mvcproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quiz.mvcproject.entities.Questionjava;

public interface JavaQuestionRepository extends JpaRepository<Questionjava, Integer> {
	public Questionjava findById(int id);

	public List<Integer> findAllById(Questionjava jav);
	
	
	// JPQL enable to create a qeryu for above method since we didint specified
	// exact information on waht it as to list all the ids if i say reference of
	// Questionjava
	// it will ask list of all tha objects so bit complicated
	// previous approach 
	//public List<Integer> findByIdsAll();
	//Conclusion we can make use of Query Annotataion which enable 
	//specify the query explicitly and we have to set nativeQuery flag status to true 
	
	// specifying to list only ids from the table entries
	@Query(value = "select id from questionjava", nativeQuery = true)

	public List<Integer> findByIdsAll();

}
