package com.revature.repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entities.AppUser;

@Repository
public class UserRepository implements CrudRepository<AppUser> {

	private SessionFactory factory;
	
	@Autowired
	public UserRepository(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}
	
	@Override
	public List<AppUser> getAll() {
		return factory.getCurrentSession().createQuery("from AppUser", AppUser.class).getResultList();
	}

	@Override
	public AppUser getById(int id) {
		return factory.getCurrentSession().get(AppUser.class, id);
	}
	
	public AppUser getUserByUsernameAndPassword(String username, String password) {
		return factory.getCurrentSession()
						.createNamedQuery("getUserByCredentials", AppUser.class)
						.setParameter("un", username)
						.setParameter("pw", password)
						.getSingleResult();
	}

	@Override
	public AppUser save(AppUser newUser) {
		return (AppUser) factory.getCurrentSession().save(newUser);
	}

	@Override
	public boolean update(AppUser updatedUser) {
		Session session = factory.getCurrentSession();
		AppUser persistentUser = session.get(AppUser.class, updatedUser.getId());
		if(persistentUser == null) return false;
		persistentUser.copyFields(updatedUser);
		return true;
	}

	@Override
	public boolean deleteById(int id) {
		Session session = factory.getCurrentSession();
		AppUser userForDeletion = session.get(AppUser.class, id);
		if(userForDeletion == null) return false;
		session.delete(userForDeletion);
		return true;
	}

}
