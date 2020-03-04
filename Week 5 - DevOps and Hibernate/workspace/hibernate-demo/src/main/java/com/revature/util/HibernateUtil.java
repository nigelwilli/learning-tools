package com.revature.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionFactory() {
		
		try {
			
			// Create the SessionFactory using the hibernate.cfg.xml file
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml"); // string not required if you kept the same name for "hibernate.cfg.xml"

			// Mapping annotated class (strategy #2)
//			config.addAnnotatedClass(Student.class);
			
			// Mapping annotated classes (strategy #3)
			assignAnnotations(config);
			
			return config.buildSessionFactory();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError();
		}
		
	}
	
	public static SessionFactory getSessionFactory() {
		return (sessionFactory == null) ? sessionFactory = buildSessionFactory() : sessionFactory;
	}
	
	@SuppressWarnings("rawtypes")
	private static void assignAnnotations(Configuration config) throws Exception {
	
		List<Class> classPaths = new ArrayList<>();
		File[] files = new File("./src/main/java/com/revature/models").listFiles();
		
		for(File file : files) {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			
			while(line != null) {
				if(line.contains("@Entity")) {
					String className = file.getName().substring(0, file.getName().length() - 5);
					classPaths.add(Class.forName("com.revature.models." + className));
					break;
				}
				
				line = reader.readLine();
			}
			
			reader.close();
		}
		
		classPaths.forEach(clazz -> config.addAnnotatedClass(clazz));
		
	}

}
