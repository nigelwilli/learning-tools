package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.models.Instructor;
import com.revature.models.InstructorDetail;
import com.revature.util.HibernateUtil;

public class OneToOneDriver {
	
	public static void main(String[] args) {
		
		try(SessionFactory factory = HibernateUtil.getSessionFactory()) {
			
			Session session = factory.getCurrentSession();
			
			// Create some instructor and details objects
			Instructor instructor_1 = new Instructor("Wezley", "Singleton", "ws@gmail.com");
			InstructorDetail details_1 = new InstructorDetail("Java", "Astronomy");
			
			Instructor instructor_2 = new Instructor("Blake", "Kruppa", "bk@gmail.com");
			InstructorDetail details_2 = new InstructorDetail("JavaScript", "Turtles");
			
			// Associate the details to their corresponding instructor
			instructor_1.setDetails(details_1);
			instructor_2.setDetails(details_2);
			
			// Persist the instructor objects
			session.beginTransaction();
			session.save(instructor_1);
			session.save(instructor_2);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
