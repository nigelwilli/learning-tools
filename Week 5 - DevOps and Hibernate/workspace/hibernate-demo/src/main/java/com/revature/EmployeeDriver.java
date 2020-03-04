package com.revature;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeDriver {
	
	public static void main(String[] args) {
		
		// Establish a session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		// ADDING AN EMPLOYEE (mapped using .hbm.xml - no JPA annotations)
		
		// Create the Employee object (transient state for now)
		Employee emp = new Employee();
		emp.setName("Wezley");
		emp.setRole("Developer");
		emp.setInsertTime(new Date());
		System.out.println("Employee before being persisted: " + emp);
		
		// Start a transaction within our session
		session.beginTransaction();
		
		// Persist/save the employee to our DB
		session.save(emp);
		
		// Commit this transaction
		session.getTransaction().commit();
		
		// Since the object is saved in the DB, it is now in the persistent state - and has an ID
		System.out.println("New employee added: " + emp);
		
		
		//----------------------------------------------------------------------------------------
		
		// Create a new session and start a new transaction
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		// Get the named query defined in the get-employee-by-name.hbm.xml file
		Query query = session.createNamedQuery("findEmployeeByName");
		query.setParameter("name", "Wezley");
		
		// Run the query and save its returned value into a collection
		List<Employee> employees = query.getResultList();
		
		// Print out the retrieved employee(s)
		employees.forEach(e -> System.out.println(e));
		
		// Close the SessionFactory - otherwise the app doesn't stop after completing the main method
		HibernateUtil.getSessionFactory().close();
	}

}
