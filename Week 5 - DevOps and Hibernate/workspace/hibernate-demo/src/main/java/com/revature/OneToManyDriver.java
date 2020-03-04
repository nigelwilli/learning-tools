package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.models.Course;
import com.revature.models.Instructor;
import com.revature.util.HibernateUtil;

public class OneToManyDriver {
	
	public static void main(String[] args) {
		
		try(SessionFactory factory = HibernateUtil.getSessionFactory()) {
			Session session = factory.getCurrentSession();
		
			session.beginTransaction();
			
			// Get Blake from the DB
			Instructor blake = session.get(Instructor.class, 11);
			
			// Create some courses that will be assigned to Blake
			Course course_1 = new Course("Hibernate Basics");
			Course course_2 = new Course("Advanced Hibernate Mappings");
			blake.addCourse(course_1);
			blake.addCourse(course_2);
			
			// Persist the courses
			session.save(course_1);
			session.save(course_2);
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
