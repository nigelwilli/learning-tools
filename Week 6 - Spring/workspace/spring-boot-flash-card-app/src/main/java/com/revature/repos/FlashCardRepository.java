package com.revature.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.entities.FlashCard;

@Repository
public interface FlashCardRepository extends CrudRepository<FlashCard, Integer>{

	FlashCard findFlashCardByQuestion(String question);
	
	@Query("from FlashCard f where f.answer = :answer")
	FlashCard getByAnswer(@Param("answer") String answer);
}
