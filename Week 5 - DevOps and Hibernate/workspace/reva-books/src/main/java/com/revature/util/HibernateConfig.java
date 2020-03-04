package com.revature.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.entities.Book;
import com.revature.entities.User;

public class HibernateConfig {
	
	private static Logger log = LogManager.getLogger(HibernateConfig.class);
	
	private static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionFactory() {
		log.info("Attempting to build SessionFactory using configure file");
		
		try {
			Configuration config = new Configuration().configure();
			config.addAnnotatedClass(User.class);
			config.addAnnotatedClass(Book.class);
			return config.buildSessionFactory();
			
		} catch (Exception e) {
			log.error("Error during SessionFactory initialization");
			e.printStackTrace();
			throw new ExceptionInInitializerError();
		}
		
	}
	
	public static SessionFactory getSessionFactory() {
		log.info("Fetching SessionFactory");
		return (sessionFactory == null) ? sessionFactory = buildSessionFactory() : sessionFactory;
	}

}
