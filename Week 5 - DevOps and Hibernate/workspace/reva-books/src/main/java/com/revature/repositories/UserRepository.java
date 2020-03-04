package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.util.HibernateConfig;

public class UserRepository implements CrudRepository<User> {
	
	private final SessionFactory sessionFactory = HibernateConfig.getSessionFactory(); 

	public List<User> getUsersByRole(Role role) {
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			List<User> users = session.createQuery("from User u where u.role = :roleName", User.class)
									  .setParameter("roleName", role.toString())
									  .getResultList();
		
			session.getTransaction().commit();
			
			return users;
			
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public User getUserByUsername(String username) {
		
		Session session = sessionFactory.getCurrentSession();

		try {
		
			session.beginTransaction();
			
			User user = session.createQuery("from User u where u.username = :un", User.class)
									  .setParameter("un", username).getSingleResult();
			
			session.getTransaction().commit();
			return user;
			
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public User getUserByCredentials(String username, String password) {

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();
			
			User user = session.createQuery("from User u where u.username = :un and u.password = :pw", User.class)
									  .setParameter("un", username)
									  .setParameter("pw", password)
									  .getSingleResult();
			
			session.getTransaction().commit();
			
			return user;
			
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@Override
	public List<User> getAll() {
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			List<User> users = session.createQuery("from User", User.class).getResultList();
			session.getTransaction().commit();
			
			return users;
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@Override
	public User getById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			User user = session.get(User.class, id);
			session.getTransaction().commit();
			
			return user;
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@Override
	public User save(User newUser) {
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			session.save(newUser);
			session.getTransaction().commit();
			
			return newUser;
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean update(User updatedUser) {

		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			session.saveOrUpdate(updatedUser);
			session.getTransaction().commit();
			
			return true;
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			User userForDeletion = session.get(User.class, id);
			if(userForDeletion == null) return true;
			session.delete(userForDeletion);
			session.getTransaction().commit();
			
			return true;
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return false;
	}

}
