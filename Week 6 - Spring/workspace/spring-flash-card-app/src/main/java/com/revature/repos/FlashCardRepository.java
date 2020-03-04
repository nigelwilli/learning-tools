package com.revature.repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entities.FlashCard;

@Repository
public class FlashCardRepository implements CrudRepository<FlashCard> {
	
	private SessionFactory factory;
	
	@Autowired
	public FlashCardRepository(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}
	
	@Override
	public List<FlashCard> getAll() {
		return factory.getCurrentSession().createQuery("from FlashCard", FlashCard.class).getResultList();
	}

	@Override
	public FlashCard getById(int id) {
		return factory.getCurrentSession().get(FlashCard.class, id);
	}
	
	@Override
	public FlashCard save(FlashCard newCard) {
		factory.getCurrentSession().save(newCard);
		return newCard;
	}
	
	@Override
	public boolean update(FlashCard updatedCard) {
		Session session = factory.getCurrentSession();
		FlashCard cardInDataSource = session.get(FlashCard.class, updatedCard.getId());
		if(cardInDataSource == null) return false;
		cardInDataSource.setQuestion(updatedCard.getQuestion());
		cardInDataSource.setAnswer(updatedCard.getAnswer());
		return true;
	}
	
	@Override
	public boolean deleteById(int id) {
		Session session = factory.getCurrentSession();
		FlashCard cardInDataSource = session.get(FlashCard.class, id);
		if(cardInDataSource == null) return false;
		session.delete(cardInDataSource);
		return true;
	}
	
}
