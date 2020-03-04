package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.FlashCard;
import com.revature.repos.FlashCardRepository;

@Service
public class FlashCardService {

	private FlashCardRepository cardRepo;
	
	@Autowired
	public FlashCardService(FlashCardRepository repo) {
		this.cardRepo = repo;
	}
	
	@Transactional(readOnly=true, isolation=Isolation.READ_COMMITTED)
	public List<FlashCard> getAll() {
		return cardRepo.getAll();
	}
	
}
