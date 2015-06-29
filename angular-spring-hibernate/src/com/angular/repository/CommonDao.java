package com.angular.repository;

import java.util.List;

import com.angular.model.SystemUser;

public interface CommonDao {
	
	public List<?> findContactByNameLike(int page, int maxResults, String search, String sort);
	
	public List<?> findUsersByNameLike(int page, int maxResults, String search, String sort);	
	

	public List<?> findAll(int page, int maxResults, String sort);
	
	public void persist(Object customUser);
	
	public void delete(int id, Class clas);	
	public void deleteContact(int contactId);

	public int findCountAll();
	
	public SystemUser findByEmail(String email);	

	
	
}
