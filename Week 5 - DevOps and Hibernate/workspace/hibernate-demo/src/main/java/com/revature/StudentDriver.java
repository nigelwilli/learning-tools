package com.revature;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.util.HibernateUtil;

public class StudentDriver {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = null;
		
		try {
			
//			// CREATE STUDENT DEMO
//			
//			// Get a session
//			session = factory.getCurrentSession();
//			
//			// Create a Student object
//			Student student_1 = new Student("Wezley", "Singleton", "ws@gmail.com");
//			
//			// Start a transaction
//			session.beginTransaction();
//			
//			// Persist/save the student as a record in the DB
//			session.save(student_1);
//			
//			// Commit the transaction
//			session.getTransaction().commit();
//			
//			// Review the results of the operation
//			System.out.println(student_1);
//			
//			// Close the session
//			session.close();
			
			//------------------------------------------------------------------------------------------
			
//			// PRIMARY KEY DEMO
//			
//			// Obtain a session
//			session = factory.getCurrentSession();
//			
//			// Create an array of students to be persisted
//			Student[] students = {
//					new Student("Blake", "Kruppa", "bk@gmail.com"),
//					new Student("Steven", "Kelsey", "sk@gmail.com"),
//					new Student("Genesis", "Bonds", "gb@gmail.com"),
//					new Student("Iago", "Pereira", "ip@gmail.com"),
//					new Student("Nigel", "Williams", "nw@gmail.com")
//			};
//			
//			for(Student s : students) System.out.println(s);
//
//			// Start a transaction
//			session.beginTransaction();
//			
//			// Save each student in the array
//			for(Student s : students) session.save(s);
//			
//			// Commit the transaction
//			session.getTransaction().commit();
//			
//			// Close the session
//			session.close();
//			
//			// Review the results of the operation
//			for(Student s : students) System.out.println(s);
			
			//------------------------------------------------------------------------------------------------------
			
			// READ STUDENT DEMO (using .get() and .load())
			
//			session = factory.getCurrentSession();
//			
//			// Add David Fay as a student to our DB
//			Student david = new Student("David", "Fay", "df@gmail.com");
//			
//			session.beginTransaction();
//			session.save(david);
//			session.getTransaction().commit();
//			
//			// Review the results of the operation
//			System.out.println(david);
//			int id = david.getId();
//			
//			session.close();
//			
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// Retrieve David from the DB using his ID
//			
//			// returns a proxy, which is then converted to our persistent object when a method is invoked on it (lazy)
////			Student retrievedStudent = session.load(Student.class, 7); 
//			
//			// returns the actual persistent object associated with the DB records (eager)
////			Student retrievedStudent = session.get(Student.class, 7);
//			
//			// throws an ObjectNotFoundException if no records are found using the specified ID
////			Student retrievedStudent = session.load(Student.class, 234567);
//			
//			// returns null if no records are found using the specified ID
//			Student retrievedStudent = session.get(Student.class, 234567);
//			
//			System.out.println(retrievedStudent);
//
//			session.getTransaction().commit();
			
			//----------------------------------------------------------------------------------------
			
//			// READ STUDENT DEMO (using Query)
//			
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// Query for all students (ordered by IDs, descending)
//			Query query_1 = session.createQuery("from Student s order by s.id desc", Student.class);
//			List<Student> students = query_1.getResultList();
//			displayStudents(students);
//			
//			// Query for students with the last name "Singleton" (value hard-coded)
//			Query query_2 = session.createQuery("from Student s where s.lastName = 'Singleton'", Student.class);
//			students = query_2.getResultList();
//			displayStudents(students);
//			
//			// Query for students with a specified last name OR a specified first name (using params)
//			Query query_3 = session.createQuery("from Student s where s.firstName = :fn OR s.lastName = :ln", Student.class);
//			query_3.setParameter("fn", "Blake");
//			query_3.setParameter("ln", "Kelsey");
//			students = query_3.getResultList();
//			displayStudents(students);
//			
//			// Query for students where their email is like something
//			Query query_4 = session.createQuery("from Student s where s.email like :email");
//			query_4.setParameter("email", "%k@gmail.com");
//			students = query_4.getResultList();
//			displayStudents(students);
			
			//---------------------------------------------------------------------------------------
			
//			// CALLING NAMED QUERIES
//			
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// Execute of our named queries for the Student class
//			Query studentQuery = session.getNamedQuery("findStudentById_HQL");
//			studentQuery.setParameter("id", 5);
//			List<Student> students = studentQuery.getResultList();
//			displayStudents(students);
//			
//			session.getTransaction().commit();
			
			//-----------------------------------------------------------------------------------
			
//			// CALLING NAMED NATIVE QUERIES
//			
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// Execute one of our named native queries
//			List<?> students = session.getNamedNativeQuery("findStudentByFirstName_SQL")
//											.setParameter("fn", "Genesis")
//											.getResultList();
//			
//			displayStudents(students);
//			
//			session.getTransaction().commit();
			
			//-----------------------------------------------------------------------------------
			
//			// READ STUDENT DEMO (using CriteriaQuery)
//			
//			/*
//			 * CriteriaQuery (formerly known as Criteria before Hibernate v5), is all about
//			 * programmatic query creation. Instead of manually typing out our queries or
//			 * invoking named queries, we can create queries using specialized objects.
//			 */
//			
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// Create a CriteriaBuilder object to build our CriteriaQuery
//			CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
//			
//			// Query for all students
//			// SQL = SELECT * FROM students
//			// HQL = from Student
//			
//			// Create our CriteriaQuery object
//			CriteriaQuery<Student> critQuery = queryBuilder.createQuery(Student.class);
//			
//			// Set the query "root" (the table we will be querying)
//			Root<Student> queryRoot = critQuery.from(Student.class);
//			
//			// Indicate the SELECT clause of the query
//			critQuery.select(queryRoot);
//			
//			// Execute the query
//			List<Student> students = session.createQuery(critQuery).getResultList();
//			displayStudents(students);
//			
//			
//			// Query for students with an email of "ws@gmail.com"
//			CriteriaQuery<Student> criteria = queryBuilder.createQuery(Student.class);
//			Root<Student> studentRoot = criteria.from(Student.class);
//			criteria.select(studentRoot);
//			criteria.where(
//				queryBuilder.equal(studentRoot.get("email"), "ws@gmail.com")
//			);
//			
//			students = session.createQuery(criteria).getResultList();
//			displayStudents(students);
			
			//----------------------------------------------------------------------------------
			
			// UPDATE STUDENT DEMO
			
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// Set some variable that has a value equal to some PK in DB
//			int studentId = 7;
//			
//			// Retrieve the object from the DB with the specified ID
//			Student myStudent = session.get(Student.class, studentId);
//
//			// Update the first name to "August" and last name to "Duet"
//			myStudent.setFirstName("August");
//			myStudent.setLastName("Duet");
//			
//			session.getTransaction().commit();
//			session.close();
			
			/*
             * We are able to update this object by simply changing the values of the fields
             * we wish to update. This is possible because the object is in the persistent
             * state when it is retrieved from the DB. It remains persistent until we either
             * detach it ourselves or its associated session is closed.
             * 
             * If the latter happens, then any "dirty" fields in the object will be automatically
             * persisted, through a process known as "automatic dirty-checking".
             */
			
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			Query updateQuery = session.createQuery("update Student s set s.email = :email where s.firstName = :fn");
//			updateQuery.setParameter("email", "ad@gmail.com");
//			updateQuery.setParameter("fn", "August");
//			updateQuery.executeUpdate();
//			
//			session.getTransaction().commit();
//			session.close();
			
			//--------------------------------------------------------------------------------------------------------
			
			// DELETE STUDENT DEMO
			
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			int studentId = 7;
//			
//			Student myStudent = session.get(Student.class, studentId);
//			session.delete(myStudent);
//			
//			session.getTransaction().commit();
//			
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			Query deleteQuery = session.createQuery("delete Student s where s.id = :id");
//			deleteQuery.setParameter("id", 4).executeUpdate();
//			
//			session.getTransaction().commit();
//			session.close();
			
			
		} catch (Exception e) {
			// If any unspecified exception occurs, rollback any active transactions
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
	}
	
	private static void displayStudents(List<?> students) {
		students.forEach(s -> System.out.println(s));
	}
}
