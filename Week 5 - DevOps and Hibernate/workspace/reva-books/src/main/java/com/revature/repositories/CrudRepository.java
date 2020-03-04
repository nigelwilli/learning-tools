package com.revature.repositories;

import java.util.List;

public interface CrudRepository<T> {
	
	List<T> getAll();
	T getById(int i);
	T save(T newObject);
	boolean update(T updatedObject);
	boolean deleteById(int id);

}
